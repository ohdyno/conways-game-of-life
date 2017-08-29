package me.ohdyno.projects.life.values

class LifeForms {
    companion object {
        val glider = arrayOf(
                arrayOf(Dead(), Alive(), Dead()),
                arrayOf(Dead(), Alive(), Alive()),
                arrayOf(Alive(), Dead(), Alive())
        )
    }
}