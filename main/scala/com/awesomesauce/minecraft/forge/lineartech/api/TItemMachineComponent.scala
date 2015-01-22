package com.awesomesauce.minecraft.forge.lineartech.api

import net.minecraft.item.ItemStack
import net.minecraftforge.common.util.ForgeDirection


trait TItemMachineComponent extends TMachineComponent {
  var itemBuffer : ItemStack = null
  var itemSide : ForgeDirection = null
  var needToPush = false
  override def acceptItem(stack: ItemStack, side: ForgeDirection) = {
    if (itemBuffer == null)
    {
      itemBuffer = stack
      itemSide = side
    }
    false
  }
  override def updateEntity() = {
    super.updateEntity()
    if (needToPush)
    {
      if (super.acceptItem(itemBuffer, itemSide)) {
        itemBuffer = null
        itemSide = null
        needToPush = false
      }
    }
  }
}
