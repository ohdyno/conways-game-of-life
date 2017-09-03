package me.ohdyno.projects.life

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import me.ohdyno.projects.life.simulate.GeneratesSeedWorld
import me.ohdyno.projects.life.simulate.OutputsWorld
import me.ohdyno.projects.life.simulate.ReplacesWorld
import me.ohdyno.projects.life.simulate.values.World
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek
import org.mockito.Mockito.verify

object SimulatesConwayTest : SubjectSpek<SimulatesConway>({
    val generatesSeedWorld: GeneratesSeedWorld = mock()
    val replacesWorld: ReplacesWorld = mock()
    val outputsWorld: OutputsWorld = mock()

    val seedWorld = World(10, 10)
    val nextWorld = World(10, 10)
    whenever(generatesSeedWorld.generate()).thenReturn(seedWorld)
    whenever(replacesWorld.replace(seedWorld)).thenReturn(nextWorld)

    subject {
        SimulatesConway(generatesSeedWorld, replacesWorld, outputsWorld)
    }

    describe("simulating Conway's Game of Life") {
        subject.simulate(2)

        it("should start with the generated seed world and, for each generation, replaces the previous world, and output put all worlds") {
            verify(generatesSeedWorld).generate()
            verify(outputsWorld).output(seedWorld)
            verify(replacesWorld).replace(seedWorld)
            verify(outputsWorld).output(nextWorld)
        }
    }
})