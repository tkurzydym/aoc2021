package day3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DayThreeTest : StringSpec({
    "Calculate Submarine Power Consumption" {

        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val powerConsumption: Int = DayThree().calculatePowerConsumption(input)

        powerConsumption shouldBe 198
    }

    "Calculate the life support rating" {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val lifeSupportRating = DayThree().calculateLifeSupportRating(input)

        lifeSupportRating shouldBe 230
    }
})