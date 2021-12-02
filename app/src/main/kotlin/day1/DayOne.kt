package day1

class DayOne {

    fun executeDayOnePartOne() {
        println("Welcome to Day One!")
        val readLines = DayOne::class.java
            .classLoader
            .getResourceAsStream("dayoneinput.txt")!!
            .bufferedReader()
            .readLines()

        println("Reading Input File!")
        val input = readLines.map { it.toInt() }.toIntArray()

        calculateIncreasedValues(input)
    }

    fun executeDayOnePartTwo() {
        println("Welcome to Day One - Part 2!")
        val readLines = DayOne::class.java
            .classLoader
            .getResourceAsStream("dayoneinput2.txt")!!
            .bufferedReader()
            .readLines()

        println("Reading Input File!")
        val input = readLines.map { it.toInt() }.toIntArray()

        calculateAmountMeasurementWindowsIncreased(input)
    }

    fun calculateAmountMeasurementWindowsIncreased(input: IntArray): Int {
        println("Calculating Measurement Windows.")

        val measurementWindows = arrayListOf<MeasurementWindow>()

        var idx = 0

        while (idx <= input.size - 3) {
            val measurementWindow = MeasurementWindow(input[idx], input[idx + 1], input[idx + 2])
            measurementWindows.add(measurementWindow)
            idx++
        }

        return calculateIncreasedValues(measurementWindows.map { it.sum() }.toIntArray())
    }


    fun calculateIncreasedValues(input: IntArray): Int {
        println("Calculating how many times the Depth increased.")
        var count = 0
        var lastValue: Int? = input.first()

        input.forEach {
            if(lastValue!! < it) {
                count++
            }
            lastValue = it
        }

        println("The Depth increased $count times")

        return count
    }


}