package day2

class DayTwo {

    fun calculateDepthAndHPosMultiplied(input: List<String>): Int {
        var depth = 0
        var hpos = 0
        var aim = 0

        input.forEach {
            val command = Pair(
                it.substringBefore(" "),
                it.substringAfter(" ").toInt()
            )

            when (command.first) {
                "forward" -> {
                    hpos += command.second
                    depth += aim * command.second
                }
                "down" -> aim += command.second
                "up" -> aim -= command.second
            }
        }

        val position = depth * hpos
        println("""
            We reachead our final position now with aiming!
            Our aim value was finally: $aim
            We reached a Depth of $depth and a horizontal position of $hpos
            Our calculated value of position is: $position
            """
        )

        return position
    }
}
