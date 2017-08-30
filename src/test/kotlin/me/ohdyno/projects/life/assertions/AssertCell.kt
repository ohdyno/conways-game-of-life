package me.ohdyno.projects.life.assertions

import me.ohdyno.projects.life.values.Alive
import me.ohdyno.projects.life.values.Cell
import me.ohdyno.projects.life.values.Coordinates
import me.ohdyno.projects.life.values.Dead
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert

class AssertCell(val target: Cell, val coordinates: Coordinates) {
    fun isAlive() {
        Assert.assertThat("Cell at $coordinates should be alive", target, IsInstanceOf.instanceOf(Alive::class.java))
    }

    fun isDead() {
        Assert.assertThat("Cell at $coordinates should be dead", target, IsInstanceOf.instanceOf(Dead::class.java))
    }

}