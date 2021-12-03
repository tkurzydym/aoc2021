/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package aoc2021

import day1.DayOne
import day2.DayTwo
import day3.DayThree

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
}

fun dayThree() {
    println("Welcome to Day Three!")
    DayThree().calculatePowerConsumption(
        readInput("daythreeinput.txt")
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
