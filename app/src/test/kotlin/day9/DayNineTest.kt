package day9

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DayNineTest: StringSpec({

    "Find Sum of Low Points on the Height Map" {

        val input = listOf(
            "2199943210",
            "3987894921",
            "9856789892",
            "8767896789",
            "9899965678",
        )

        val sum = DayNine().findBasinsOnHeightMap(input)
        sum shouldBe 1134
    }
})