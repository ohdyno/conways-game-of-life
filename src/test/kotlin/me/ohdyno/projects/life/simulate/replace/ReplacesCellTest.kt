package me.ohdyno.projects.life.simulate.replace

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.values.*
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import me.ohdyno.projects.life.simulate.values.Cell.Live
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek

object ReplacesCellTest : SubjectSpek<ReplacesCell>({
    describe("Replacing a single cell based on B3/S23") {
        subject { ReplacesCell() }
        World(width = 3, height = 3, lifeForms = DefinedLifeForms.glider to Coordinates.origin)

        given("the cell has 3 neighbors") {
            given("the cell is dead") {
                on("replace") {
                    val result = subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Dead, withLiveNeighbors = 3) to Coordinates.origin), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Live))
                    }
                }
            }

            given("the cell is live") {
                on("replace") {
                    val result = subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 3) to Coordinates.origin), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Live))
                    }
                }
            }
        }

        given("the cell has 2 neighbors") {
            given("the cell is live") {
                on("replace") {
                    val result = subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 2) to Coordinates.origin), Coordinates(1, 1))
                    it("returns a live cell") {
                        assert.that(result, equalTo(Live))
                    }
                }
            }
        }

        given("for all other conditions") {
            on("replace") {
                it("returns a dead cell") {
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 1) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 4) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 5) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 6) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 7) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                    assert.that(subject.replace(World(3, 3, lifeForms = create3x3LifeForm(centeredAroundCell = Live, withLiveNeighbors = 8) to Coordinates.origin), Coordinates(1, 1)), equalTo(Dead))
                }
            }
        }

    }
})

private fun create3x3LifeForm(centeredAroundCell: Cell, withLiveNeighbors: Int): LifeForm {
    var liveNeighbors = 0
    return Array(3) { y ->
        Array(3) { x ->
            if (x == 1 && y == 1) {
                centeredAroundCell
            } else {
                if (liveNeighbors < withLiveNeighbors) {
                    liveNeighbors++
                    Live
                } else {
                    Dead
                }
            }
        }
    }
}