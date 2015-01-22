package com.awesomesauce.minecraft.forge.lineartech.core.te

import com.awesomesauce.minecraft.forge.lineartech.api.{ILinearTechNetworkComponent, TBasicComponent}
import net.minecraft.inventory.IInventory
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection


class TileEntityItemIn extends TileEntity with TBasicComponent {
  override def updateEntity() = {
    for (side <- ForgeDirection.values()) {
      val opp = side.getOpposite
      val te = getWorldObj.getTileEntity(xCoord + opp.offsetX, yCoord + opp.offsetY, zCoord + opp.offsetZ)
      if (te.isInstanceOf[IInventory]) {
        val inventory = te.asInstanceOf[IInventory]
        for (i <- Range(0, inventory.getSizeInventory)) {
          if (inventory.getStackInSlot(i) != null) {
            val stack = inventory.decrStackSize(i, 1)
            val te = getWorldObj.getTileEntity(xCoord + side.offsetX, yCoord + side.offsetY, zCoord + side.offsetZ)
            te.isInstanceOf[ILinearTechNetworkComponent] && te.asInstanceOf[ILinearTechNetworkComponent].acceptItem(stack, opp)
          }
        }
      }
    }
  }
}
