package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.DefinedLifeForms
import me.ohdyno.projects.life.simulate.values.World

class GeneratesSeedWorld {
    fun generate(): World {
        return World(width = 10, height = 10,
                lifeForms = DefinedLifeForms.glider to Coordinates(3,3))
    }
}