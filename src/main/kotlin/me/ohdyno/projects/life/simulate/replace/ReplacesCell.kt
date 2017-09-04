package me.ohdyno.projects.life.simulate.replace

import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Cell.Live
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.World

class ReplacesCell {
    fun replace(world: World, coordinates: Coordinates): Cell {
        return when (neighborsForCell(world, coordinates)) {
            3 -> Live
            2 -> world.at(coordinates)
            else -> Dead
        }
    }

    private fun neighborsForCell(world: World, coordinates: Coordinates): Int {
        var neighborCount = 0
        for (dx in -1..1) {
            for (dy in -1..1) {
                val neighborCoordinate = coordinates.translateXBy(dx).translateYBy(dy)
                if (coordinates != neighborCoordinate && world.at(neighborCoordinate) == Live) {
                    neighborCount++
                }
            }
        }
        return neighborCount
    }
}