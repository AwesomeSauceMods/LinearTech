package com.awesomesauce.minecraft.forge.lineartech.api

import net.minecraft.item.ItemStack


trait TItemTransformerMachineComponent extends TItemMachineComponent with TEnergyCostMachineComponent {
  def getOutputStack(stack: ItemStack): ItemStack
  def getEnergyUse(stack: ItemStack): Int
  override def energyCostToDo = if (itemBuffer != null && getOutputStack(itemBuffer) != null) getEnergyUse(itemBuffer) else 0
  def performEnergyCostTask() = {
    itemBuffer = getOutputStack(itemBuffer)
    needToPush = true
  }
}
