package com.awesomesauce.minecraft.forge.lineartech.api


trait TEnergyCostMachineComponent extends TMachineComponent {
  def energyCostToDo: Int
  def performEnergyCostTask()
  var energyCost = 0
  var doingTask = false
  override def performTask(energy: Int):Int = {
    if (!doingTask && energyCostToDo > 0)
    {
      energyCost = energyCostToDo
      doingTask = true
    }
    if (doingTask) {
      energyCost -= energy
      if (energyCost <= 0) {
        performEnergyCostTask()
        doingTask = false
        return -energyCost
      }
      0
    }
    else
    {
      energy
    }
  }
}
