package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.matchers.Life
import me.ohdyno.projects.life.simulate.values.Coordinates
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek

object GeneratesSeedWorldTest : SubjectSpek<GeneratesSeedWorld>({
    subject { GeneratesSeedWorld() }

    on("generate") {
        val result = subject.generate()

        it("generates a world with a glider") {

            Life.`in`(result).at(Coordinates(y = 0, x = 0)).isDead()
            Life.`in`(result).at(Coordinates(y = 0, x = 1)).isAlive()
            Life.`in`(result).at(Coordinates(y = 0, x = 2)).isDead()

            Life.`in`(result).at(Coordinates(y = 1, x = 0)).isDead()
            Life.`in`(result).at(Coordinates(y = 1, x = 1)).isAlive()
            Life.`in`(result).at(Coordinates(y = 1, x = 2)).isAlive()

            Life.`in`(result).at(Coordinates(y = 2, x = 0)).isAlive()
            Life.`in`(result).at(Coordinates(y = 2, x = 1)).isDead()
            Life.`in`(result).at(Coordinates(y = 2, x = 2)).isAlive()
        }
    }
})