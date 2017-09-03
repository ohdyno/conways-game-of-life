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

            Life.`in`(result).at(Coordinates(x = 0, y = 0)).isDead()
            Life.`in`(result).at(Coordinates(x = 0, y = 1)).isAlive()
            Life.`in`(result).at(Coordinates(x = 0, y = 2)).isDead()

            Life.`in`(result).at(Coordinates(x = 1, y = 0)).isDead()
            Life.`in`(result).at(Coordinates(x = 1, y = 1)).isAlive()
            Life.`in`(result).at(Coordinates(x = 1, y = 2)).isAlive()

            Life.`in`(result).at(Coordinates(x = 2, y = 0)).isAlive()
            Life.`in`(result).at(Coordinates(x = 2, y = 1)).isDead()
            Life.`in`(result).at(Coordinates(x = 2, y = 2)).isAlive()
        }
    }
})