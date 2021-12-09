package day9

class DayNine {
    fun findBasinsOnHeightMap(input: List<String>): Int {
        println("Lets find the low spots and basins on the height map!")
        val lowPointsWithBasinCoordinates = mutableListOf<Pair<Int, Set<Pair<Int, Int>>>>()

        input.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, column ->
                val currentPositionValue = Character.getNumericValue(column)
                val adjacentValues = getAdjacentIntValues(columnIndex, row, rowIndex, input)

                if (isLowPoint(currentPositionValue, adjacentValues)) {
                    val basin = mutableSetOf(Pair(rowIndex, columnIndex))
                    basin += getAdjacentValuesIncludedInBasin(input, rowIndex, row, columnIndex)

                    lowPointsWithBasinCoordinates.add(Pair(currentPositionValue, basin))
                }
            }
        }

        val multipliedSizeOfThreeLargestBasins = lowPointsWithBasinCoordinates
            .map { it.second.size }
            .sortedDescending()
            .subList(0, 3)
            .reduce(Int::times)

        println(
            """
            The low Points with their basin size are $lowPointsWithBasinCoordinates. 
            We have a multiplied size of the three largest basins: $multipliedSizeOfThreeLargestBasins
            """
        )

        return multipliedSizeOfThreeLargestBasins
    }

    private fun isLowPoint(
        currentPositionValue: Int,
        adjacentValues: List<Int>
    ) = currentPositionValue < adjacentValues.minOrNull()!!

    private fun getAdjacentValuesIncludedInBasin(
        input: List<String>,
        rowIndex: Int,
        currentRow: String,
        columnIndex: Int
    ): Set<Pair<Int, Int>> {
        val adjacentValues = getAdjacentValues(columnIndex, currentRow, rowIndex, input)
        val uniqueBasinCoordinates: MutableSet<Pair<Int, Int>> = mutableSetOf()

        adjacentValues.forEach {
            if (it.first != '9' && it.first > currentRow[columnIndex]) {
                uniqueBasinCoordinates.add(it.second)
                uniqueBasinCoordinates += getAdjacentValuesIncludedInBasin(
                    input,
                    it.second.first,
                    input[it.second.first],
                    it.second.second
                )
            }
        }

        return uniqueBasinCoordinates
    }

    private fun getAdjacentIntValues(
        columnIndex: Int,
        currentRow: String,
        rowIndex: Int,
        input: List<String>
    ): List<Int> {
        val adjacentValues = getAdjacentValues(columnIndex, currentRow, rowIndex, input)

        return adjacentValues.map { it.first }.map { Character.getNumericValue(it) }
    }

    private fun getAdjacentValues(
        columnIndex: Int,
        currentRow: String,
        rowIndex: Int,
        input: List<String>
    ): List<Pair<Char, Pair<Int, Int>>> {
        val left =
            if (columnIndex - 1 >= 0) Pair(currentRow[columnIndex - 1], Pair(rowIndex, columnIndex - 1)) else null
        val right = if (columnIndex + 1 < currentRow.length) Pair(
            currentRow[columnIndex + 1],
            Pair(rowIndex, columnIndex + 1)
        ) else null
        val up =
            if (rowIndex - 1 >= 0) Pair(input[rowIndex - 1][columnIndex], Pair(rowIndex - 1, columnIndex)) else null
        val down = if (rowIndex + 1 < input.size) Pair(
            input[rowIndex + 1][columnIndex],
            Pair(rowIndex + 1, columnIndex)
        ) else null

        val numList: List<Pair<Char, Pair<Int, Int>>> = mutableListOf(left, right, up, down).filterNotNull()

        return numList
    }
}