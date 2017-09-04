package me.ohdyno.projects.life.simulate.values

data class Coordinates(val x: Int, val y: Int) {
    companion object {
        val origin = Coordinates(0, 0)
    }

    fun translateX(delta: Int): Coordinates {
        return Coordinates(x = this.x + delta, y = this.y)
    }

    fun translateY(delta: Int): Coordinates {
        return Coordinates(x = this.x, y = this.y + delta)
    }
}