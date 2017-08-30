package me.ohdyno.projects.life

import me.ohdyno.projects.life.assertions.AssertCell
import me.ohdyno.projects.life.values.Coordinates
import me.ohdyno.projects.life.values.LifeForms
import me.ohdyno.projects.life.values.World
import org.junit.Test

class ReplacesCellTest {
    private val subject = ReplacesCell()
    private val glider = World(width = 3, height = 3).with(LifeForms.glider)

    @Test
    fun `if the cell is dead and it has 3 neighbors, it is born`() {
        val coordinates = Coordinates(x = 0, y = 2)

        val result = subject.replace(glider, coordinates)

        AssertCell(result, coordinates).isAlive()
    }

    @Test
    fun `if the cell is alive and it has 2 or 3 neighbors, it survives`() {
        val coordinates = Coordinates(x = 2, y = 2)

        val result = subject.replace(glider, coordinates)

        AssertCell(result, coordinates).isAlive()

    }

    @Test
    fun `if the cell is alive and it has 4 or more neighbors, the cell dies due to over population`() {
        val coordinates = Coordinates(x = 1, y = 1)

        val result = subject.replace(glider, coordinates)

        AssertCell(result, coordinates).isDead()
    }

    @Test
    fun `if the cell is alive and it has 1 or fewer neighbor, the cell dies due to starvation`() {
        val coordinates = Coordinates(x = 2, y = 0)

        val result = subject.replace(glider, coordinates)

        AssertCell(result, coordinates).isDead()
    }
}