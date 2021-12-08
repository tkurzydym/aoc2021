package day6

class DaySix {
    fun countOfLanternfishesAfterDays(input: List<Int>, days: Int): Long {
        println("Lets find out how many lanternfishes there will be in $days Days!")
        val fishCount = input.toMutableList()

        val array = LongArray(9, { 0L })

        val map = fishCount.groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()
        map.forEach { array[it.key] = it.value  }

        for (day in 1..days) {
            //val eachCount = fishCount.groupingBy { it }.eachCount()
            //fishCount.replaceAll { if(it == 0) 6 else it - 1 }
            val startOfDay = array.clone()
            array[6] = array[6] + startOfDay[0]
            array[8] = array[8] + startOfDay[0]

            array.forEachIndexed { index, value ->
//                if(index != 0) {
//                    array[index - 1] = value
//                }
                array[index] = value - startOfDay[index]
                if(index != 0) {
                    array[index - 1] = array[index - 1] + startOfDay[index]
                }
            }

        }

        println(
            """
            The Fish count in $days Days will be ${array.sum()}
            """
        )

        return array.sum()
    }
}