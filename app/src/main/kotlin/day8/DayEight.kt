package day8

class DayEight {
    fun countUniqueDigitsInOutput(input: List<String>): Int {
        println("We have to decode the input to find some digits!")

        val outputValues = input.flatMap { it.split(" ") }.toList()

        val sum = outputValues.groupingBy { it.count() }.eachCount()
            .filter { it.key == 7 || it.key == 4 || it.key == 3 || it.key == 2 }
            .values.sum()

        println("We counted the digits 1, 4, 7 and 8 exactly $sum times")
        return sum
    }
}