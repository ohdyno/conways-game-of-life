package me.ohdyno.projects.life.simulate

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import me.ohdyno.projects.life.simulate.values.Cell
import me.ohdyno.projects.life.simulate.values.Coordinates
import me.ohdyno.projects.life.simulate.values.World
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import java.io.ByteArrayOutputStream
import java.io.PrintStream

object OutputsWorldTest : SubjectSpek<OutputsWorld>({
    describe("Outputting a world") {
        val outputStream: PrintStream = mock()
        val outputCell: OutputCell = mock()
        whenever(outputCell.output(Cell.Live)).thenReturn("live")
        whenever(outputCell.output(Cell.Dead)).thenReturn("dead")
        subject { OutputsWorld(outputStream, outputCell) }

        given("A world with dead and live cells") {
            val world = World(width = 2, height = 1, lifeForms = arrayOf(
                    arrayOf(Cell.Live),
                    arrayOf(Cell.Dead)
            ) to Coordinates.origin)

            on("outputting the world") {
                subject.output(world)

                it("should call output cell on every cell in the world and send the result to outputStream") {
                    verify(outputCell).output(Cell.Live)
                    verify(outputCell).output(Cell.Dead)
                    verify(outputStream).print("live")
                    verify(outputStream).print("dead")
                    verify(outputStream).println()
                }
            }
        }
    }
})