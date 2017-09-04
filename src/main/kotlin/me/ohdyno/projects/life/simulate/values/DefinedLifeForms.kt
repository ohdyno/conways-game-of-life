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

fun LifeForm.forEachCellWithCoordinates(fn: (Cell, Coordinates) -> Unit) {
    this.forEachIndexed { y, row ->
        row.forEachIndexed { x, cell ->
            fn(cell, Coordinates(x, y))
        }
    }
}