package day6

class DaySix {
    fun countOfLanternfishesAfterDays(input: List<Int>, days: Int): Int {
        println("Lets find out how many lanternfishes there will be in 80 Days!")
        val fishCount = input.toMutableList()

        for (day in 1..days) {
            val eachCount = fishCount.groupingBy { it }.eachCount()
            fishCount.replaceAll { if(it == 0) 6 else it - 1 }
            if(eachCount.containsKey(0) && eachCount[0]!! > 0) fishCount.addAll(Array(eachCount[0]!!) { 8 })
        }

        println(
            """
            The Fish count in 80 Days will be ${fishCount.size} 
            """
        )

        return fishCount.size
    }
}