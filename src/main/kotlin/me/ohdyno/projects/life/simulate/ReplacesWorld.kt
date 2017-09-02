package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.replace.ReplacesCell
import me.ohdyno.projects.life.simulate.values.World

class ReplacesWorld(private val replacesCell: ReplacesCell) {
    fun replace(oldWorld: World): World {
        return oldWorld.map(replacesCell::replace)
    }
}