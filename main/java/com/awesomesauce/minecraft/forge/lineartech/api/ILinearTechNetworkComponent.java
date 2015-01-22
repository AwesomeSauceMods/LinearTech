package com.awesomesauce.minecraft.forge.lineartech.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by sandra on 1/22/15.
 */
public interface ILinearTechNetworkComponent {
    boolean acceptItem(ItemStack stack, ForgeDirection side);
    boolean acceptFluid(FluidStack stack, ForgeDirection side);
    boolean acceptEnergy(int energy, ForgeDirection side);
}
