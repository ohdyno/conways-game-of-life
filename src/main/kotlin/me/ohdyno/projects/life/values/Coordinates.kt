package me.ohdyno.projects.life.values

data class Coordinates(val x: Int, val y: Int) {

    fun translateX(delta: Int): Coordinates {
        return Coordinates(x = this.x + delta, y = this.y)
    }

    fun translateY(delta: Int): Coordinates {
        return Coordinates(x = this.x, y = this.y + delta)
    }
}