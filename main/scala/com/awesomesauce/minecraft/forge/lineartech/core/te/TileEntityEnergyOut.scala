package com.awesomesauce.minecraft.forge.lineartech.core.te

import cofh.api.energy.{IEnergyConnection, IEnergyReceiver}
import com.awesomesauce.minecraft.forge.lineartech.api.{ILinearTechNetworkComponent, TBasicComponent}
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection


class TileEntityEnergyOut extends TileEntity with TBasicComponent with IEnergyConnection {
  override def acceptEnergy(energy: Int, side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord+opp.offsetX, yCoord+opp.offsetY, zCoord+opp.offsetZ)
    te.isInstanceOf[IEnergyReceiver] && te.asInstanceOf[IEnergyReceiver].receiveEnergy(side, energy, false) == energy
  }
  override def canConnectEnergy(from: ForgeDirection) = {
    true
  }
}
