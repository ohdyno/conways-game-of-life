package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.matchers.Life
import me.ohdyno.projects.life.simulate.values.Coordinates
import org.junit.Test

class GeneratesSeedWorldTest {
    private val subject = GeneratesSeedWorld()

    @Test
    fun `it generates a world with a glider`() {
        val result = subject.generate()

        Life.`in`(result).at(Coordinates(x = 0, y = 0)).isDead()
        Life.`in`(result).at(Coordinates(x = 0, y = 1)).isAlive()
        Life.`in`(result).at(Coordinates(x = 0, y = 2)).isDead()

        Life.`in`(result).at(Coordinates(x = 1, y = 0)).isDead()
        Life.`in`(result).at(Coordinates(x = 1, y = 1)).isAlive()
        Life.`in`(result).at(Coordinates(x = 1, y = 2)).isAlive()

        Life.`in`(result).at(Coordinates(x = 2, y = 0)).isAlive()
        Life.`in`(result).at(Coordinates(x = 2, y = 1)).isDead()
        Life.`in`(result).at(Coordinates(x = 2, y = 2)).isAlive()
    }
}