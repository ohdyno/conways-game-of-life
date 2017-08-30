package me.ohdyno.projects.life.values

open class World(val width: Int, val height: Int) {
    protected open val contents: MutableMap<Coordinates, Cell> = mutableMapOf()

    fun at(coordinates: Coordinates): Cell {
        return contents[coordinates] ?: Dead()
    }

    fun with(shape: LifeForm, origin: Coordinates = Coordinates(x = 0, y = 0)): World {
        shape.forEachIndexed { row, columns ->
            columns.forEachIndexed { column, cell ->
                contents[Coordinates(row, column).translateX(origin.x).translateY(origin.y)] = cell
            }
        }

        return this
    }
}