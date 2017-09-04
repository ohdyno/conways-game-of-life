package me.ohdyno.projects.life.simulate.values

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.values.Cell.Alive
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object LifeFormIteratorTest : Spek({
    describe("iterating through LifeForm's coordinates") {
        given("a row of cells") {
            val subject = arrayOf(
                    arrayOf(Alive, Dead, Alive)
            )

            on("getting coordinates") {
                val result = subject.coordinates

                it("should return the coordinates of the row") {
                    assert.that(result.next(), equalTo(Coordinates(x = 0, y = 0)))
                    assert.that(result.next(), equalTo(Coordinates(x = 1, y = 0)))
                    assert.that(result.next(), equalTo(Coordinates(x = 2, y = 0)))
                }
            }
        }

        given("a column of cells") {
            val subject = arrayOf(
                    arrayOf(Alive),
                    arrayOf(Dead),
                    arrayOf(Alive)
            )

            on("getting coordinates") {
                val result = subject.coordinates

                it("should return the coordinates of the column") {
                    assert.that(result.next(), equalTo(Coordinates(y = 0, x = 0)))
                    assert.that(result.next(), equalTo(Coordinates(y = 1, x = 0)))
                    assert.that(result.next(), equalTo(Coordinates(y = 2, x = 0)))
                }
            }
        }
    }
})