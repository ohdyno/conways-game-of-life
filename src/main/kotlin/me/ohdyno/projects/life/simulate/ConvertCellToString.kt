package me.ohdyno.projects.life.simulate

import me.ohdyno.projects.life.simulate.values.Cell

class ConvertCellToString {
    fun convert(cell: Cell): String = if (cell == Cell.Live) "+" else "0"

}