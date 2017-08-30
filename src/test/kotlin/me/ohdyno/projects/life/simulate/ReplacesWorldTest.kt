package me.ohdyno.projects.life.simulate

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import me.ohdyno.projects.life.simulate.replace.ReplacesCell
import me.ohdyno.projects.life.simulate.values.*
import org.hamcrest.core.Is
import org.hamcrest.core.IsSame
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ReplacesWorldTest {
    @InjectMocks
    private lateinit var subject: ReplacesWorld

    @Mock
    private lateinit var replacesCell: ReplacesCell

    @Test
    fun `it replaces the world by calling replace on all of the cells in the world`() {
        val world = World(width = 10, height = 10).with(shape = LifeForms.glider)
        whenever(replacesCell.replace(eq(world), any())).thenReturn(mock())

        subject.replace(world)

        verifyReplaceForAllCellsIn(world)
    }

    private fun verifyReplaceForAllCellsIn(world: World) {
        for (x in 0 until world.width) {
            for (y in 0 until world.height) {
                verify(replacesCell).replace(world, Coordinates(x, y))
            }
        }
    }

    @Test
    fun `it returns a new world with cells that were replaced`() {
        val world = World(width = 1, height = 1)
        val replacementCell: Cell = Alive()
        whenever(replacesCell.replace(world, Coordinates(0, 0))).thenReturn(replacementCell)

        val result = subject.replace(world)

        Assert.assertThat(result.at(Coordinates(0, 0)), Is.`is`(IsSame.sameInstance(replacementCell)))
    }
}