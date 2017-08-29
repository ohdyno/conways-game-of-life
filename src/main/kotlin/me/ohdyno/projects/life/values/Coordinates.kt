package me.ohdyno.projects.life.values

data class Coordinates(val x: Int, val y: Int) {
    fun translateOriginTo(target: Coordinates): Coordinates {
        return Coordinates(x + target.x, y + target.y)
    }
}