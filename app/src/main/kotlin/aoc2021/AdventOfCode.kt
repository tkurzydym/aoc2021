/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package aoc2021

import day1.DayOne
import day2.DayTwo
import day3.DayThree
import day4.DayFour
import day5.DayFive
import day6.DaySix

class App {
    val greeting: String
        get() {
            return "Merry Christmas!"
        }
}

fun main() {
    println(App().greeting)

    dayOne()
    dayTwo()
    dayThree()
    dayFour()
    dayFive()
    daySix()
}

fun daySix() {
    println("Welcome to Day Six!")
    DaySix().countOfLanternfishesAfter80Days(
        readInput("daysixinput.txt")[0].split(",").map { it.toInt() }
    )
}

fun dayFive() {
    println("Welcome to Day Five")
    val parseInputToLinePoints = DayFive().parseInputToLinePoints(
        readInput("dayfiveinput.txt")
    )
    DayFive().calculateOverlappingPoints(parseInputToLinePoints)
}

fun dayFour() {
    println("Welcome to Day Three!")
    DayFour().calculateBingoScore(
        readInput("dayfour-drawnumbers.txt")[0],
        readInput("dayfour-boards.txt")
    )
}

fun dayThree() {
    println("Welcome to Day Three!")
    val input = readInput("daythreeinput.txt")
    DayThree().calculatePowerConsumption(
        input
    )
    DayThree().calculateLifeSupportRating(
        input
    )
}

fun dayTwo() {
    println("Welcome to Day Two!")
    DayTwo().calculateDepthAndHPosMultiplied(
        readInput("daytwoinput.txt")
    )
}

private fun dayOne() {
    println("Welcome to Day One!")
    DayOne().calculateIncreasedValues(
        readInput("dayoneinput.txt")
            .map { it.toInt() }
            .toIntArray()
    )

    println("Welcome to Day One - Part 2!")
    DayOne().calculateAmountMeasurementWindowsIncreased(
        readInput("dayoneinput2.txt")
            .map { it.toInt() }
            .toIntArray()
    )
}


fun readInput(resourceName: String): List<String> {
    val readLines = App::class.java
        .classLoader
        .getResourceAsStream(resourceName)!!
        .bufferedReader()
        .readLines()
    return readLines
}
