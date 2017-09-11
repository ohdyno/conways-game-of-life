package me.ohdyno.projects.life.simulate.output

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.output.ConvertCellToString
import me.ohdyno.projects.life.simulate.values.Cell
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek

object ConvertCellToStringTest : SubjectSpek<ConvertCellToString>({
    describe("Converting a Cell to String format") {
        subject { ConvertCellToString() }

        it("should be able to convert both live and dead cells") {
            assert.that(subject.convert(Cell.Live), equalTo("0"))
            assert.that(subject.convert(Cell.Dead), equalTo("-"))
        }
    }
})