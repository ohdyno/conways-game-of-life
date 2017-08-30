package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.values.LifeForms
import me.ohdyno.projects.life.simulate.values.World

class GeneratesSeedWorld {
    fun generate(): World {
        return World(10, 10).with(LifeForms.glider)
    }

}