package me.ohdyno.projects.life.simulate.values

import me.ohdyno.projects.life.simulate.values.Cell.Dead
import me.ohdyno.projects.life.simulate.values.Cell.Live

object DefinedLifeForms {
    val glider = arrayOf(
            arrayOf(Dead, Live, Dead),
            arrayOf(Dead, Dead, Live),
            arrayOf(Live, Live, Live)
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