package com.awesomesauce.minecraft.forge.lineartech.core

import com.awesomesauce.minecraft.forge.core.lib.util.ItemUtil
import com.awesomesauce.minecraft.forge.lineartech.LTModule
import com.awesomesauce.minecraft.forge.lineartech.core.te._
import net.minecraft.block.Block
import net.minecraft.block.material.Material

object LinearTechCore extends LTModule {
  def name = "Core"
  var itemIn: Block = null
  var itemOut: Block = null
  var fluidIn: Block = null
  var fluidOut: Block = null
  var energyIn: Block = null
  var energyOut: Block = null
  def preInit() = {
    energyIn = ItemUtil.makeBlock(lt, "energyIn", Material.iron, () => new TileEntityEnergyIn(1000))
    energyOut = ItemUtil.makeBlock(lt, "energyOut", Material.iron, () => new TileEntityEnergyOut)
  }
  def init() = {

  }
  def postInit() = {

  }
}
