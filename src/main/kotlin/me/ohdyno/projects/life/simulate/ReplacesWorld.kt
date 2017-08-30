package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.replace.ReplacesCell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.replace.values.MutableWorld
import me.ohdyno.projects.life.simulate.values.World

class ReplacesWorld(private val replacesCell: ReplacesCell) {
    fun replace(oldWorld: World): World {
        val newWorld = MutableWorld(oldWorld)
        for (x in 0 until oldWorld.width) {
            for (y in 0 until oldWorld.height) {
                val coordinates = Coordinates(x, y)
                val replacementCell = replacesCell.replace(oldWorld, coordinates)
                newWorld.replace(coordinates, replacementCell)
            }
        }
        return newWorld
    }
}