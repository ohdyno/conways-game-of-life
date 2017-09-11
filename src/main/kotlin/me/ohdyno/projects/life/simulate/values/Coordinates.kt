package me.ohdyno.projects.life.simulate.values

data class Coordinates(val x: Int, val y: Int) {
    companion object {
        val origin = Coordinates(0, 0)
    }

    fun translateXBy(delta: Int): Coordinates {
        return Coordinates(x = this.x + delta, y = this.y)
    }

    fun translateYBy(delta: Int): Coordinates {
        return Coordinates(x = this.x, y = this.y + delta)
    }

    operator fun plus(that: Coordinates): Coordinates {
        return this.translateXBy(that.x).translateYBy(that.y)
    }

    override fun toString(): String {
        return "(x=$x, y=$y)"
    }
}