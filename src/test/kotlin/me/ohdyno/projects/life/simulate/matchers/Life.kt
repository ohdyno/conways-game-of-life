package me.ohdyno.projects.life.simulate.matchers

import me.ohdyno.projects.life.simulate.assertions.AssertCell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.World

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