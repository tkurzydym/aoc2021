package day2

class DayTwo {

    fun calculateDepthAndHPosMultiplied(input: List<String>): Int {
        var depth = 0
        var hpos = 0

        input.forEach {
            val split = Pair(
                it.substringBefore(" "),
                it.substringAfter(" ").toInt()
            )

            when (split.first) {
                "forward" -> hpos += split.second
                "down" -> depth += split.second
                "up" -> depth -= split.second
            }
        }

        val position = depth * hpos
        println(
            """
            We reachead our final position of 
            depth: $depth and horizontal position: $hpos
            Our calculated value of position is: $position
            """
        )

        return position
    }
}
