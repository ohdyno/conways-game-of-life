package me.ohdyno.projects.life

import me.ohdyno.projects.life.values.LifeForms
import me.ohdyno.projects.life.values.World

class GeneratesSeedWorld {
    fun generate(): World {
        return World(10, 10).with(LifeForms.glider)
    }

}