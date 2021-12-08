package day7

class DaySeven {
    fun lowestFuelConsumption(input: List<Int>): Int {

        var lowestFuelConsumption: Int? = null

        (0..input.maxOrNull()!!).forEach { position ->
            var currentLowest = 0
            input.forEach {
                if (it > position) {
                    currentLowest += getFuelCost(position, it)
                } else if (it < position) {
                    currentLowest += getFuelCost(it, position)
                }
            }
            lowestFuelConsumption = if (lowestFuelConsumption == null) {
                currentLowest
            } else {
                if (currentLowest < lowestFuelConsumption!!) currentLowest else lowestFuelConsumption
            }
        }

        println("We have a lowest fuel consumption of $lowestFuelConsumption")

        return lowestFuelConsumption!!
    }

    private fun getFuelCost(start: Int, end: Int): Int {
        var cost = 0

        var i = 1;
        while(i <= end - start) {
            cost += i
            i++
        }

        return cost
    }
}