package me.ohdyno.projects.life

import me.ohdyno.projects.life.values.World
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`

import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SimulatesConwayTest {

    @InjectMocks
    private lateinit var subject: SimulatesConway

    @Mock
    private lateinit var generatesSeedWorld: GeneratesSeedWorld

    @Mock
    private lateinit var replacesWorld: ReplacesWorld

    @Mock
    private lateinit var outputsWorld: OutputsWorld

    @Test
    fun `simulates Conway's game of life for a given number of generations`() {
        val seedWorld = World()
        val nextWorld = World()
        `when`(generatesSeedWorld.generate()).thenReturn(seedWorld)
        `when`(replacesWorld.replace(seedWorld)).thenReturn(nextWorld)

        subject.simulate(2)

        verify(generatesSeedWorld).generate()
        verify(outputsWorld).output(seedWorld)
        verify(replacesWorld).replace(seedWorld)
        verify(outputsWorld).output(nextWorld)
    }
}