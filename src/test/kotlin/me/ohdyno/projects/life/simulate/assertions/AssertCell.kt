package me.ohdyno.projects.life.simulate.assertions

import me.ohdyno.projects.life.simulate.values.Alive
import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.Dead
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