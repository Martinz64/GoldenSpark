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
import net.timeworndevs.golden_spark.gui.PoweredFurnaceScreenHandler;
import net.timeworndevs.golden_spark.init.GSBlockEntityTypes;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class PoweredFurnaceBlockEntity extends AbstractFurnaceBlockEntity {


    public PoweredFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(GSBlockEntityTypes.POWERED_FURNACE_TYPE, pos, state, RecipeType.SMELTING);
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
        return new PoweredFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }


    /*public static void tick(World world, BlockPos pos, BlockState state, PoweredFurnaceBlockEntity blockEntity) {
        AbstractFurnaceBlockEntity.tick(world,pos,state,blockEntity);
    }*/

    public static void mtick(World world, BlockPos pos, BlockState state, PoweredFurnaceBlockEntity blockEntity) {
        blockEntity.inventory.set(1, new ItemStack(Items.COAL));
        PoweredFurnaceBlockEntity.tick(world,pos,state,blockEntity);
        blockEntity.inventory.set(1, new ItemStack(Items.AIR));
    }


    @Override
    protected int getFuelTime(ItemStack fuel) {
        if((this.energyStorage.amount - 10) > 0){
            this.energyStorage.amount -= 10;
            this.markDirty();
            return 1;
        }
        return 0;
    }
}
