package me.ohdyno.projects.life.values

class World {
    private val contents = mapOf(
            Coordinates(x = 0, y = 0) to Dead(),
            Coordinates(x = 0, y = 1) to Alive(),
            Coordinates(x = 0, y = 2) to Dead(),

            Coordinates(x = 1, y = 0) to Dead(),
            Coordinates(x = 1, y = 1) to Alive(),
            Coordinates(x = 1, y = 2) to Alive(),

            Coordinates(x = 2, y = 0) to Alive(),
            Coordinates(x = 2, y = 1) to Dead(),
            Coordinates(x = 2, y = 2) to Alive()
    )

    fun at(coordinates: Coordinates): Cell {
        return contents[coordinates] ?: Dead()
    }
}