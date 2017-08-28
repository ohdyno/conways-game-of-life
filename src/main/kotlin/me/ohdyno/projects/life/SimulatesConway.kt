package me.ohdyno.projects.life

class SimulatesConway(private val generatesSeedWorld: GeneratesSeedWorld, private val replacesWorld: ReplacesWorld, private val outputsWorld: OutputsWorld) {
    fun simulate(generations: Int) {
        var world = generatesSeedWorld.generate()
        var currentGeneration = 0
        do {
            outputsWorld.output(world)
            world = replacesWorld.replace(world)
            currentGeneration++
        } while (currentGeneration < generations)
    }

}