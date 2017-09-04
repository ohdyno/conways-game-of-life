package me.ohdyno.projects.life.simulate

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import me.ohdyno.projects.life.simulate.values.Cell.Dead
import me.ohdyno.projects.life.simulate.values.Cell.Live
import me.ohdyno.projects.life.simulate.values.Coordinates
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek

object GeneratesSeedWorldTest : SubjectSpek<GeneratesSeedWorld>({
    subject { GeneratesSeedWorld() }

    on("generate") {
        val result = subject.generate()

        it("generates a world with a glider") {
            assert.that(result.at(Coordinates(y = 0, x = 0)), equalTo(Dead))
            assert.that(result.at(Coordinates(y = 0, x = 1)), equalTo(Live))
            assert.that(result.at(Coordinates(y = 0, x = 2)), equalTo(Dead))

            assert.that(result.at(Coordinates(y = 1, x = 0)), equalTo(Dead))
            assert.that(result.at(Coordinates(y = 1, x = 1)), equalTo(Live))
            assert.that(result.at(Coordinates(y = 1, x = 2)), equalTo(Live))

            assert.that(result.at(Coordinates(y = 2, x = 0)), equalTo(Live))
            assert.that(result.at(Coordinates(y = 2, x = 1)), equalTo(Dead))
            assert.that(result.at(Coordinates(y = 2, x = 2)), equalTo(Live))
        }
    }
})