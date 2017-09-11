package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.World
import java.io.PrintStream

class OutputsWorld(private val out: PrintStream, val outputCell: OutputCell) {
    fun output(world: World) {
        world.forEach { coordinates ->
            out.print(outputCell.output(this.at(coordinates)))
            if (coordinates.isEdgeOf(this)) {
                out.println()
            }
        }
    }
}

private fun Coordinates.isEdgeOf(world: World): Boolean {
    return this.x == world.width - 1;
}
