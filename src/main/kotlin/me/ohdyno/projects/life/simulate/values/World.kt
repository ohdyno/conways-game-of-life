package me.ohdyno.projects.life.simulate.values

class World(val width: Int, val height: Int, vararg lifeForms: Pair<LifeForm, Coordinates>) {

    private val contents: MutableMap<Coordinates, Cell> by lazy {
        val _contents: MutableMap<Coordinates, Cell> = mutableMapOf()
        lifeForms.forEach { (lifeForm, origin) ->
            lifeForm.coordinates.forEach { coordinates ->
                val translatedCoordinates = coordinates.translateX(origin.x).translateY(origin.y)
                _contents[translatedCoordinates] = lifeForm.cellAt(coordinates)
            }
        }
        _contents
    }

    fun at(coordinates: Coordinates): Cell {
        return contents[coordinates] ?: Cell.Dead
    }

    fun forEach(fn: World.(Coordinates) -> Unit) {
        (0 until width).forEach { x ->
            (0 until height).forEach { y ->
                this.fn(Coordinates(x, y))
            }
        }
    }

    fun map(fn: (World, Coordinates) -> Cell): World {
        val newWorld = World(width = width, height = height)

        forEach { coordinates ->
            newWorld.contents[coordinates] = fn(this, coordinates)
        }

        return newWorld
    }
}