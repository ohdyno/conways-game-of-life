package me.ohdyno.projects.life.matchers

import me.ohdyno.projects.life.assertions.AssertCell
import me.ohdyno.projects.life.values.Coordinates
import me.ohdyno.projects.life.values.World

class Life(val world: World) {
    companion object {
        fun `in`(world: World): Life {
            return Life(world)
        }
    }

    fun at(coordinates: Coordinates): AssertCell {
        return AssertCell(world.at(coordinates), coordinates)
    }
}