package day2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DayTwoTest : StringSpec({

    "track depth and horizontal position with aim" {

        val input: List<String> = listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2"
        )

        val calculateDepthAndHPosMultiplied =
            DayTwo().calculateDepthAndHPosMultiplied(input)

        calculateDepthAndHPosMultiplied shouldBe 900
    }

})