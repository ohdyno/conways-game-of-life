package me.ohdyno.projects.life.simulate

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.values.Cell
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek

object ConvertCellToStringTest : SubjectSpek<ConvertCellToString>({
    describe("Converting a Cell to String format") {
        subject { ConvertCellToString() }

        it("should convert a live cell to +") {
            assert.that(subject.convert(Cell.Live), equalTo("+"))
        }

        it("should convert a dead cell to 0") {
            assert.that(subject.convert(Cell.Dead), equalTo("0"))
        }
    }
})