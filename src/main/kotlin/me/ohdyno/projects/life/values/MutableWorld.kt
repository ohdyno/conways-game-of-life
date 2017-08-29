package me.ohdyno.projects.life.values

class MutableWorld(oldWorld: World) : World(oldWorld.width, oldWorld.height) {
    override val contents: MutableMap<Coordinates, Cell> = mutableMapOf()

    fun replace(coordinates: Coordinates, cell: Cell) {
        contents[coordinates] = cell
    }
}