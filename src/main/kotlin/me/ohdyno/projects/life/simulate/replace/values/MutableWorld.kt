package me.ohdyno.projects.life.simulate.replace.values

import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.World

class MutableWorld(oldWorld: World) : World(oldWorld.width, oldWorld.height) {
    override val contents: MutableMap<Coordinates, Cell> = mutableMapOf()

    fun replace(coordinates: Coordinates, cell: Cell) {
        contents[coordinates] = cell
    }
}