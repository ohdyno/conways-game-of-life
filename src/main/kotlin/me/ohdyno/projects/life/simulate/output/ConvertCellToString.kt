package me.ohdyno.projects.life.simulate.output

import me.ohdyno.projects.life.simulate.values.Cell

class ConvertCellToString {
    fun convert(cell: Cell): String = if (cell == Cell.Live) "0" else "-"

}