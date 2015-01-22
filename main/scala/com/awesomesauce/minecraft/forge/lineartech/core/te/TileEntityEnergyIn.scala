package com.awesomesauce.minecraft.forge.lineartech.core.te

import cofh.api.energy.IEnergyReceiver
import com.awesomesauce.minecraft.forge.lineartech.api.{ILinearTechNetworkComponent, TBasicComponent}
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection


class TileEntityEnergyIn(cap: Int) extends TileEntity with TBasicComponent with IEnergyReceiver {
  override def getEnergyStored(side: ForgeDirection) = 0
  override def getMaxEnergyStored(side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord + opp.offsetX, yCoord + opp.offsetY, zCoord + opp.offsetZ)
    if (te.isInstanceOf[ILinearTechNetworkComponent])
      cap
    else 0
  }
  override def canConnectEnergy(side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord + opp.offsetX, yCoord + opp.offsetY, zCoord + opp.offsetZ)
    if (te.isInstanceOf[ILinearTechNetworkComponent])
      true
    else false
  }
  override def receiveEnergy(side: ForgeDirection, amount: Int, simulate: Boolean) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord+opp.offsetX, yCoord+opp.offsetY, zCoord+opp.offsetZ)
    if (simulate && te.isInstanceOf[ILinearTechNetworkComponent]) cap
    else if (te.isInstanceOf[ILinearTechNetworkComponent] && te.asInstanceOf[ILinearTechNetworkComponent].acceptEnergy(amount, side)) cap
    else 0
  }
}
