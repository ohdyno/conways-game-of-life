package me.ohdyno.projects.life.simulate.assertions

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.isA
import com.natpryce.hamkrest.should.describedAs
import me.ohdyno.projects.life.simulate.values.Alive
import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.Dead

class AssertCell(val target: Cell, val coordinates: Coordinates) {
    fun isAlive() {
        assert.that(target, isA<Alive>()).describedAs("Cell at $coordinates should be alive")
    }

    fun isDead() {
        assert.that(target, isA<Dead>()).describedAs("Cell at $coordinates should be dead")
    }

}