import me.ohdyno.projects.life.SimulatesConway
import me.ohdyno.projects.life.simulate.output.ConvertCellToString
import me.ohdyno.projects.life.simulate.GeneratesSeedWorld
import me.ohdyno.projects.life.simulate.OutputsWorld
import me.ohdyno.projects.life.simulate.ReplacesWorld
import me.ohdyno.projects.life.simulate.replace.ReplacesCell

fun main(args: Array<String>) {
    SimulatesConway(
            generatesSeedWorld = GeneratesSeedWorld(),
            outputsWorld = OutputsWorld(System.out, ConvertCellToString()),
            replacesWorld = ReplacesWorld(ReplacesCell())
    ).simulate(5)
}