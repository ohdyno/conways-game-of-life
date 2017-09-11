package me.ohdyno.projects.life.simulate.values

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek

object WorldTest : SubjectSpek<World>({
    describe("World specs") {
        subject { World(width = 3, height = 2) }

        on("iterating through the coordinates") {
            val recordCoordinates = ArrayList<Coordinates>()

            subject.forEach { coordinates ->
                recordCoordinates.add(coordinates)
            }

            it("should iterate through the coordinates in left to right and up to down") {
                assert.that(recordCoordinates, equalTo(arrayListOf(
                        Coordinates(0,0), Coordinates(1,0), Coordinates(2,0),
                        Coordinates(0,1), Coordinates(1,1), Coordinates(2,1)
                )))
            }
        }
    }
})