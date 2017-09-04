package me.ohdyno.projects.life.simulate.values

import me.ohdyno.projects.life.simulate.values.Cell.Alive
import me.ohdyno.projects.life.simulate.values.Cell.Dead

private typealias Grid = MutableMap<Coordinates, Cell>

class World(val width: Int, val height: Int, vararg lifeForms: Pair<LifeForm, Coordinates>) {
    private val contents: Grid = mutableMapOf()

    init {
        addLifeForms(lifeForms)
    }

    private fun addLifeForms(lifeForms: Array<out Pair<LifeForm, Coordinates>>) {
        lifeForms.forEach { (lifeForm, origin) ->
            addLifeForm(lifeForm, origin)
        }
    }

    private fun addLifeForm(lifeForm: LifeForm, translation: Coordinates) {
        lifeForm.forEachCellWithCoordinates { cell, coordinates ->
            contents.set(cell, at = coordinates + translation)
        }
    }

    fun at(coordinates: Coordinates): Cell {
        return contents[coordinates] ?: Dead
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
            newWorld.contents.set(fn(this, coordinates), at = coordinates)
        }

        return newWorld
    }
}

private fun Grid.set(cell: Cell, at: Coordinates) {
    if (cell == Alive) {
        this[at] = cell
    }
}