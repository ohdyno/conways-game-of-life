package me.ohdyno.projects.life.simulate.replace

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.values.*
import me.ohdyno.projects.life.simulate.values.Cell.Alive
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek

object ReplacesCellTest : SubjectSpek<ReplacesCell>({
    describe("Replacing a single cell based on B3/S23") {
        subject { ReplacesCell() }
        World(width = 3, height = 3).with(DefinedLifeForms.glider)

        given("the cell has 3 neighbors") {
            given("the cell is dead") {
                on("replace") {
                    val result = subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Dead, withAliveNeighbors = 3)), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Alive))
                    }
                }
            }

            given("the cell is alive") {
                on("replace") {
                    val result = subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 3)), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Alive))
                    }
                }
            }
        }

        given("the cell has 2 neighbors") {
            given("the cell is alive") {
                on("replace") {
                    val result = subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 2)), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Alive))
                    }
                }
            }
        }

        given("for all other conditions") {
            on("replace") {
                it("returns a dead cell") {
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 1)), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 4)), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 5)), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 6)), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 7)), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3).with(create3x3LifeForm(centeredAroundCell = Alive, withAliveNeighbors = 8)), Coordinates(1, 1)), equalTo(Dead))
                }
            }
        }

    }
})

private fun create3x3LifeForm(centeredAroundCell: Cell, withAliveNeighbors: Int): LifeForm {
    var aliveNeighbors = 0
    return Array(3) { y ->
        Array(3) { x ->
            if (x == 1 && y == 1) {
                centeredAroundCell
            } else {
                if (aliveNeighbors < withAliveNeighbors) {
                    aliveNeighbors++
                    Alive
                } else {
                    Dead
                }
            }
        }
    }
}