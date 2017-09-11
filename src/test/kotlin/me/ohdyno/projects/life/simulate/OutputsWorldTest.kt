package me.ohdyno.projects.life.simulate

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
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
import java.io.PrintStream

object OutputsWorldTest : SubjectSpek<OutputsWorld>({
    describe("Outputting a world") {
        val outputStream: PrintStream = mock()
        val convertCellToString: ConvertCellToString = mock()
        whenever(convertCellToString.convert(Cell.Live)).thenReturn("live")
        whenever(convertCellToString.convert(Cell.Dead)).thenReturn("dead")

        subject { OutputsWorld(outputStream, convertCellToString) }

        given("A world with dead and live cells") {
            val world = World(width = 2, height = 1, lifeForms = arrayOf(
                    arrayOf(Cell.Live),
                    arrayOf(Cell.Dead)
            ) to Coordinates.origin)

            on("outputting the world") {
                subject.output(world)

                it("should call convert cell on every cell in the world and send the result to outputStream") {
                    verify(convertCellToString).convert(Cell.Live)
                    verify(convertCellToString).convert(Cell.Dead)
                    verify(outputStream).print("live")
                    verify(outputStream).print("dead")
                    verify(outputStream, times(2)).println()
                }
            }
        }
    }
})