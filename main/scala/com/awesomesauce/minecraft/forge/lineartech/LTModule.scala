package com.awesomesauce.minecraft.forge.lineartech


trait LTModule {
  def lt = LinearTech
  def name: String
  def preInit()
  def init()
  def postInit()
}
