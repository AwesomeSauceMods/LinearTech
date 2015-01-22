package com.awesomesauce.minecraft.forge.lineartech.api

import net.minecraftforge.common.util.ForgeDirection


trait TMachineComponent extends TBasicComponent {
  def performTask(energy: Int): Int
  override def acceptEnergy(energy: Int, side: ForgeDirection) = {
    super.acceptEnergy(performTask(energy), side)
  }
}
