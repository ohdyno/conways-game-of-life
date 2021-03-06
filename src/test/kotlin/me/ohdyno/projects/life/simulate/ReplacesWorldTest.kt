package me.ohdyno.projects.life.simulate

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.sameInstance
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import me.ohdyno.projects.life.simulate.replace.ReplacesCell
import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Cell.Live
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.DefinedLifeForms
import me.ohdyno.projects.life.simulate.values.World
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek
import org.mockito.Mockito.verify

object ReplacesWorldTest : SubjectSpek<ReplacesWorld>({
    val replacesCell: ReplacesCell = mock()

    subject {
        ReplacesWorld(replacesCell)
    }

    describe("Replacing a new world") {
        it("should replace every cell in the world") {
            val world = World(width = 10, height = 10, lifeForms = DefinedLifeForms.glider to Coordinates.origin)
            whenever(replacesCell.replace(eq(world), any())).thenReturn(mock())

            subject.replace(world)

            world.forEach { coordinates ->
                verify(replacesCell).replace(this, coordinates)
            }
        }

        it("should return a new World with Cells that were replaced") {
            val world = World(width = 1, height = 1)
            val replacementCell: Cell = Live
            whenever(replacesCell.replace(world, Coordinates.origin)).thenReturn(replacementCell)

            val result = subject.replace(world)

            assert.that(result.at(Coordinates.origin), sameInstance(replacementCell))
        }
    }
})
