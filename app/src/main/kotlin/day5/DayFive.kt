package day5

class DayFive {

    fun parseInputToLinePoints(inputList: List<String>): List<Pair<Pair<Int, Int>, Pair<Int,Int>>> {
        val map = inputList.map { it.split(" -> ") }.map { pairs ->
            val src = pairs[0].split(",").map { it.toInt() }
            val dst = pairs[1].split(",").map { it.toInt() }

            Pair(Pair(src[0], src[1]), Pair(dst[0], dst[1]))
        }
        return map
    }

    fun calculateOverlappingPoints(linePoints: List<Pair<Pair<Int, Int>, Pair<Int,Int>>>): Int {

        println("Lets find out where the vents are that we have to avoid!")

        val maxX = linePoints.flatMap { listOf(it.first, it.second) }.maxOf { it.first }
        val maxY = linePoints.flatMap { listOf(it.first, it.second) }.maxOf { it.second }

        val emptyMatrixWithZeros = emptyMatrixWithZeros(maxX, maxY)

        linePoints.forEach {
            if (it.first.first == it.second.first) {
                if(it.first.second < it.second.second) {
                    for(y in it.first.second..it.second.second ) {
                        emptyMatrixWithZeros[it.first.first][y]++
                    }
                } else if(it.first.second > it.second.second) {
                    for(y in it.first.second downTo it.second.second ) {
                        emptyMatrixWithZeros[it.first.first][y]++
                    }
                }
            } else if (it.first.second == it.second.second) {
                if(it.first.first < it.second.first) {
                    for (x in it.first.first..it.second.first) {
                        emptyMatrixWithZeros[x][it.first.second]++
                    }
                } else if(it.first.first > it.second.first) {
                    for (x in it.first.first downTo it.second.first) {
                        emptyMatrixWithZeros[x][it.first.second]++
                    }
                }
            } else {
                val xRange: IntProgression =
                    if(it.first.first < it.second.first) it.first.first ..it.second.first
                    else it.first.first downTo it.second.first

                val yRange: IntProgression =
                    if(it.first.second < it.second.second) it.first.second ..it.second.second
                    else it.first.second downTo it.second.second

                val xIterator = xRange.iterator()
                val yIterator = yRange.iterator()

                while(yIterator.hasNext() && yIterator.hasNext()) {
                    emptyMatrixWithZeros[xIterator.next()][yIterator.next()]++
                }
            }
        }

        val count = emptyMatrixWithZeros.flatMap { it.asSequence() }.count { it >= 2 }

        println(
            """
            We found $count lines that are really dangerous! We should avoid them.
            """
        )

        return count
    }

    private fun emptyMatrixWithZeros(maxX: Int, maxY: Int): Array<IntArray> {
        return Array(maxX + 1) { IntArray(maxY + 1) { 0 } }
    }
}
