package com.awesomesauce.minecraft.forge.lineartech

import com.awesomesauce.minecraft.forge.core.lib.TAwesomeSauceMod
import com.awesomesauce.minecraft.forge.core.lib.util.ItemUtil
import com.awesomesauce.minecraft.forge.lineartech.core.LinearTechCore
import com.awesomesauce.minecraft.forge.lineartech.ore.LinearTechOre
import com.awesomesauce.minecraft.forge.lineartech.te.TileEntityLinearMatrix
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{ModMetadata, Mod}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.{ItemStack, Item}
import net.minecraftforge.oredict.{ShapelessOreRecipe, ShapedOreRecipe, OreDictionary}

@Mod(modid = "LinearTech", name="Linear Technologies", version="0.1.0", modLanguage = "scala")
object LinearTech extends TAwesomeSauceMod {

  @Mod.Metadata("LinearTech")
  var metadata: ModMetadata = null

  @EventHandler
  def aspri(e: FMLPreInitializationEvent) = super.awesomesaucepreinit(e)

  @EventHandler
  def asi(e: FMLInitializationEvent) = super.awesomesauceinit(e)

  @EventHandler
  def aspoi(e: FMLPostInitializationEvent) = super.awesomesaucepostinit(e)

  def getModID = "LinearTech"

  def getModName = "Linear Technologies"

  def getTextureDomain = "LinearTech"
  def getTabIconItem = () => GameRegistry.findItem("LinearTech", "linearMatrix")
  val modules = scala.collection.mutable.Set[LTModule]()
  var linearMatrix: Block = null
  def addModule(module: LTModule) = {
    if (config.get("Modules", module.name, true).getBoolean) {
      modules.add(module)
    }
  }
  def addModules() = {
    addModule(LinearTechCore)
    addModule(LinearTechOre)
  }
  def preInit() = {
    linearMatrix = ItemUtil.makeBlock(this, "linearMatrix", Material.rock, () => new TileEntityLinearMatrix)

    addModules()
    for (m <- modules) {
      m.preInit()
    }
  }
  def init() = {
    for (m <- modules)
    {
      m.init()
    }
  }
  def postInit() = {
    for (m <- modules)
    {
      m.postInit()
    }
  }
}
