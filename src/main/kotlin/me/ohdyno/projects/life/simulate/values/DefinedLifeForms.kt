package me.ohdyno.projects.life.simulate.values

import me.ohdyno.projects.life.simulate.values.Cell.Alive
import me.ohdyno.projects.life.simulate.values.Cell.Dead

object DefinedLifeForms {
    val glider = arrayOf(
            arrayOf(Dead, Alive, Dead),
            arrayOf(Dead, Alive, Alive),
            arrayOf(Alive, Dead, Alive)
    )
}

typealias LifeForm = Array<Array<Cell>>

val LifeForm.coordinates: Iterator<Coordinates>
    get() = object : Iterator<Coordinates> {
        private var x = 0
        private var y = 0
        private val height = this@coordinates.size
        private val width = this@coordinates[0].size

        override fun hasNext(): Boolean {
            return x < width && y < height
        }

        override fun next(): Coordinates {
            val result = Coordinates(x, y)
            x++
            if (endOfRow(x)) {
                y++
                x = 0
            }
            return result
        }

        private fun endOfRow(x: Int): Boolean {
            return x == width
        }
    }

fun LifeForm.cellAt(coordinates: Coordinates): Cell {
    val (x, y) = coordinates
    return this[y][x]
}