package net.timeworndevs.golden_spark.block_entity;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.timeworndevs.golden_spark.GSMain;
import net.timeworndevs.golden_spark.init.GSBlockEntityTypes;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class PoweredFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public final RecipeManager.MatchGetter<Inventory, ? extends AbstractCookingRecipe> mMatchGetter;

    public PoweredFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(GSBlockEntityTypes.POWERED_FURNACE_TYPE, pos, state, RecipeType.SMELTING);
        this.mMatchGetter = RecipeManager.createCachedMatchGetter(RecipeType.SMELTING);
    }

    public static long MAX_ENERGY = 10000;

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(MAX_ENERGY, MAX_ENERGY, MAX_ENERGY) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };

    protected Text getContainerName() {
        return Text.translatable("container.furnace");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal;

    boolean isBurning(){
        return this.burnTime > 0;
    }

    public static void tick(World world, BlockPos pos, BlockState state, PoweredFurnaceBlockEntity blockEntity) {
        //System.out.println("TICK");
        boolean bl = blockEntity.burnTime > 0;
        boolean bl2 = false;
        if (blockEntity.burnTime > 0) {
            --blockEntity.burnTime;
        }

        ItemStack itemStack = (ItemStack)blockEntity.inventory.get(1);
        boolean bl3 = !((ItemStack)blockEntity.inventory.get(0)).isEmpty() || true;
        boolean bl4 = !itemStack.isEmpty();
        if (blockEntity.isBurning() || bl3) {
            Recipe recipe;
            if (bl3) {
                System.out.println("recipe");
                Optional<? extends AbstractCookingRecipe> op = blockEntity.mMatchGetter.getFirstMatch(blockEntity, world);
                if(op.isPresent()) {
                    recipe = op.get();
                    GSMain.LOGGER.info("AAAB",recipe);
                } else {
                    recipe = null;

                }
                GSMain.LOGGER.info("AAA",recipe);
            } else {
                recipe = null;
            }

            int i = blockEntity.getMaxCountPerStack();
            if (!(blockEntity.isBurning()) && canAcceptRecipeOutput(world.getRegistryManager(), recipe, blockEntity.inventory, i)) {
                blockEntity.burnTime = 10;//blockEntity.getFuelTime(itemStack);
                blockEntity.fuelTime = blockEntity.burnTime;
            }

            if (canAcceptRecipeOutput(world.getRegistryManager(), recipe, blockEntity.inventory, i)) {
                ++blockEntity.cookTime;
                if (blockEntity.cookTime == blockEntity.cookTimeTotal) {
                    blockEntity.cookTime = 0;
                    blockEntity.cookTimeTotal = getCookTime(world, blockEntity);
                    if (craftRecipe(world.getRegistryManager(), recipe, blockEntity.inventory, i)) {
                        blockEntity.setLastRecipe(recipe);
                    }

                    bl2 = true;
                }
            } else {
                blockEntity.cookTime = 0;
            }
        } else if (!(blockEntity.burnTime > 0) && blockEntity.cookTime > 0) {
            blockEntity.cookTime = MathHelper.clamp(blockEntity.cookTime - 2, 0, blockEntity.cookTimeTotal);
        }

        if (bl != (blockEntity.burnTime > 0)) {
            bl2 = true;
            state = (BlockState)state.with(AbstractFurnaceBlock.LIT, blockEntity.isBurning());
            world.setBlockState(pos, state, 3);
        }

        if (bl2) {
            markDirty(world, pos, state);
        }

    }



    private static boolean canAcceptRecipeOutput(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe, DefaultedList<ItemStack> slots, int count) {
        if (!((ItemStack)slots.get(0)).isEmpty() && recipe != null) {
            ItemStack itemStack = recipe.getOutput(registryManager);
            if (itemStack.isEmpty()) {
                return false;
            } else {
                ItemStack itemStack2 = (ItemStack)slots.get(2);
                if (itemStack2.isEmpty()) {
                    return true;
                } else if (!ItemStack.areItemsEqual(itemStack2, itemStack)) {
                    return false;
                } else if (itemStack2.getCount() < count && itemStack2.getCount() < itemStack2.getMaxCount()) {
                    return true;
                } else {
                    return itemStack2.getCount() < itemStack.getMaxCount();
                }
            }
        } else {
            return false;
        }
    }
    private static boolean craftRecipe(DynamicRegistryManager registryManager, @Nullable Recipe<?> recipe, DefaultedList<ItemStack> slots, int count) {
        if (recipe != null && canAcceptRecipeOutput(registryManager, recipe, slots, count)) {
            ItemStack itemStack = (ItemStack)slots.get(0);
            ItemStack itemStack2 = recipe.getOutput(registryManager);
            ItemStack itemStack3 = (ItemStack)slots.get(2);
            if (itemStack3.isEmpty()) {
                slots.set(2, itemStack2.copy());
            } else if (itemStack3.isOf(itemStack2.getItem())) {
                itemStack3.increment(1);
            }

            if (itemStack.isOf(Blocks.WET_SPONGE.asItem()) && !((ItemStack)slots.get(1)).isEmpty() && ((ItemStack)slots.get(1)).isOf(Items.BUCKET)) {
                slots.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemStack.decrement(1);
            return true;
        } else {
            return false;
        }
    }

    private static int getCookTime(World world, AbstractFurnaceBlockEntity furnace) {
        return 200;
    }
}
