package me.ohdyno.projects.life

import me.ohdyno.projects.life.values.*

class ReplacesCell {
    fun replace(world: World, coordinates: Coordinates): Cell {
        return when (neighborsForCell(world, coordinates)) {
            3 -> Alive()
            2 -> world.at(coordinates).copy()
            else -> Dead()
        }
    }

    private fun neighborsForCell(world: World, coordinates: Coordinates): Int {
        var neighborCount = 0
        for (dx in -1..1) {
            for (dy in -1..1) {
                val neighborCoordinate = coordinates.translateX(dx).translateY(dy)
                if (coordinates != neighborCoordinate && world.at(neighborCoordinate) is Alive) {
                    neighborCount++
                }
            }
        }
        return neighborCount
    }

    private fun Cell.copy(): Cell {
        return this.javaClass.newInstance()
    }
}