package day9

class DayNine {
    fun findLowPointSum(input: List<String>): Int {
        println("Lets find the low spots on the height map!")
        val lowPoints = mutableListOf<Int>()

        input.forEachIndexed { inputIndex, it ->
            it.forEachIndexed{index, char ->
                val left = if(index - 1 >= 0) it[index - 1] else null
                val right = if(index + 1 < it.length) it[index + 1] else null
                val up = if(inputIndex - 1 >= 0) input[inputIndex - 1][index] else null
                val down = if(inputIndex + 1 < input.size) input[inputIndex + 1][index] else null

                val numList = mutableListOf(left, right, up, down).filterNotNull().map { Character.getNumericValue(it) }
                val numericValue = Character.getNumericValue(char)
                if(numericValue < numList.minOrNull()!!) lowPoints.add(numericValue)
            }
        }

        val riskLevelSummed = lowPoints.sum().plus(lowPoints.size)

        println(
            """
            The low points are $lowPoints. 
            We have a summed risk level of $riskLevelSummed
            """)
        return riskLevelSummed
    }
}