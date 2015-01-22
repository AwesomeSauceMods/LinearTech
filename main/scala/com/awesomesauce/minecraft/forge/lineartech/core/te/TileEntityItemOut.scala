package com.awesomesauce.minecraft.forge.lineartech.core.te

import com.awesomesauce.minecraft.forge.core.lib.util.InventoryUtil
import com.awesomesauce.minecraft.forge.lineartech.api.TBasicComponent
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection


class TileEntityItemOut extends TileEntity with TBasicComponent {
  override def acceptItem(stack: ItemStack, side: ForgeDirection) = {
    val opp = side.getOpposite
    val te = getWorldObj.getTileEntity(xCoord + opp.offsetX, yCoord + opp.offsetY, zCoord + opp.offsetZ)
    te.isInstanceOf[IInventory] && InventoryUtil.addStackToInventory(te.asInstanceOf[IInventory], stack)
  }
}
