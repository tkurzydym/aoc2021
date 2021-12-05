package day5

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class DayFiveTest : StringSpec({
    "Find overlapping Vent lines" {

        val inputPoints = listOf(
            Pair(Pair(0, 9), Pair(5, 9)),
            Pair(Pair(8, 0), Pair(0, 8)),
            Pair(Pair(9, 4), Pair(3, 4)),
            Pair(Pair(2, 2), Pair(2, 1)),
            Pair(Pair(7, 0), Pair(7, 4)),
            Pair(Pair(6, 4), Pair(2, 0)),
            Pair(Pair(0, 9), Pair(2, 9)),
            Pair(Pair(3, 4), Pair(1, 4)),
            Pair(Pair(0, 0), Pair(8, 8)),
            Pair(Pair(5, 5), Pair(8, 2)),
        )

        val calculateOverlappingPoints = DayFive().calculateOverlappingPoints(inputPoints)

        calculateOverlappingPoints shouldBe 12
    }

    "Parse Input List to PairList" {
        val inputList = listOf(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2"
        )

        val expectedPairs = listOf(
            Pair(Pair(0, 9), Pair(5, 9)),
            Pair(Pair(8, 0), Pair(0, 8)),
            Pair(Pair(9, 4), Pair(3, 4)),
            Pair(Pair(2, 2), Pair(2, 1)),
            Pair(Pair(7, 0), Pair(7, 4)),
            Pair(Pair(6, 4), Pair(2, 0)),
            Pair(Pair(0, 9), Pair(2, 9)),
            Pair(Pair(3, 4), Pair(1, 4)),
            Pair(Pair(0, 0), Pair(8, 8)),
            Pair(Pair(5, 5), Pair(8, 2)),
        )

        val parseInputToLinePoints = DayFive().parseInputToLinePoints(inputList)

        parseInputToLinePoints shouldContainExactly expectedPairs
    }
})