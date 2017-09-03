package me.ohdyno.projects.life.simulate.values

class World(val width: Int, val height: Int) {
    private val contents: MutableMap<Coordinates, Cell> = mutableMapOf()

    fun at(coordinates: Coordinates): Cell {
        return contents[coordinates] ?: Dead()
    }

    fun with(shape: LifeForm, origin: Coordinates = Coordinates(x = 0, y = 0)): World {
        shape.forEachIndexed { row, columns ->
            columns.forEachIndexed { column, cell ->
                val translatedCoordinates = Coordinates(row, column).translateX(origin.x).translateY(origin.y)
                contents[translatedCoordinates] = cell
            }
        }

        return this
    }

    fun forEach(fn: (Coordinates) -> Unit) {
        (0 until width).forEach { x ->
            (0 until height).forEach { y ->
                fn(Coordinates(x, y))
            }
        }
    }

    fun map(fn: (World, Coordinates) -> Cell): World {
        val newWorld = World(this.width, this.height)

        this.forEach { coordinates ->
            newWorld.contents[coordinates] = fn(this, coordinates)
        }

        return newWorld
    }
}