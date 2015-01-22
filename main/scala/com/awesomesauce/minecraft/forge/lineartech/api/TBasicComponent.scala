package com.awesomesauce.minecraft.forge.lineartech.api

import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection
import net.minecraftforge.fluids.FluidStack


trait TBasicComponent extends TileEntity with ILinearTechNetworkComponent {
  override def acceptItem(stack: ItemStack, side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord+opp.offsetX, yCoord+opp.offsetY, zCoord+opp.offsetZ)
    te.isInstanceOf[ILinearTechNetworkComponent] && te.asInstanceOf[ILinearTechNetworkComponent].acceptItem(stack, side)
  }
  override def acceptFluid(stack: FluidStack, side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord+opp.offsetX, yCoord+opp.offsetY, zCoord+opp.offsetZ)
    te.isInstanceOf[ILinearTechNetworkComponent] && te.asInstanceOf[ILinearTechNetworkComponent].acceptFluid(stack, side)
  }
  override def acceptEnergy(energy: Int, side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord+opp.offsetX, yCoord+opp.offsetY, zCoord+opp.offsetZ)
    te.isInstanceOf[ILinearTechNetworkComponent] && te.asInstanceOf[ILinearTechNetworkComponent].acceptEnergy(energy, side)
  }
}
