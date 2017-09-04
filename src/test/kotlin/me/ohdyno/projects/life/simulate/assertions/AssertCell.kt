package me.ohdyno.projects.life.simulate.assertions

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.should.describedAs
import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import me.ohdyno.projects.life.simulate.values.Cell.Live
import me.ohdyno.projects.life.simulate.values.Coordinates

class AssertCell(val target: Cell, val coordinates: Coordinates) {
    fun isAlive() {
        assert.that(target, equalTo(Live)).describedAs("Cell at $coordinates should be alive")
    }

    fun isDead() {
        assert.that(target, equalTo(Dead)).describedAs("Cell at $coordinates should be dead")
    }

}