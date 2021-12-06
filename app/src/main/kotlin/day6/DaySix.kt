package day6

class DaySix {
    fun countOfLanternfishesAfter80Days(input: List<Int>): Int {
        println("Lets find out how many lanternfishes there will be in 80 Days!")
        val fishCount = input.toMutableList()
        for (day in 1..80) {
            var addCount = 0

            fishCount.replaceAll { if(it == 0) {
                addCount++
                6
            } else {
                it - 1
            }}
            fishCount.addAll(Array(addCount) {8})
        }

        println(
            """
            The Fish count in 80 Days will be ${fishCount.size} 
            """
        )

        return fishCount.size
    }
}