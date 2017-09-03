package me.ohdyno.projects.life.simulate.values

object DefinedLifeForms {
    val glider = arrayOf(
            arrayOf(Dead(), Alive(), Dead()),
            arrayOf(Dead(), Alive(), Alive()),
            arrayOf(Alive(), Dead(), Alive())
    )
}

typealias LifeForm = Array<Array<Cell>>