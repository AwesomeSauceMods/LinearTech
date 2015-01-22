package com.awesomesauce.minecraft.forge.lineartech.ore.te

import com.awesomesauce.minecraft.forge.lineartech.api.{TItemTransformerMachineComponent, TMachineComponent}
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity

class TileEntityCrusher extends TileEntity with TItemTransformerMachineComponent {
  override def getOutputStack(stack: ItemStack) = {
    null
  }
  override def getEnergyUse(stack: ItemStack) = {
    0
  }
}
