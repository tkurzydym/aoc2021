package day4

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class DayFourTest: StringSpec({
    "convert board matrix to IntArray" {
        val testBoard = DayFour().convertStringBoardToIntArray(
            listOf(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
            )
        )

        testBoard[0][0] shouldBe 22
        testBoard[0][4] shouldBe 0
        testBoard[1][0] shouldBe 8
        testBoard[1][4] shouldBe 24
        testBoard[2][0] shouldBe 21
        testBoard[2][4] shouldBe 7
        testBoard[4][0] shouldBe 1
        testBoard[4][4] shouldBe 19
    }

    "convert multiple boards to IntArrays" {
        val boardList = DayFour().retrieveBoardList(
            listOf(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19",
                "",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6"
            )
        )

        val board1 = arrayOf(
            intArrayOf(22, 13, 17, 11, 0),
            intArrayOf(8, 2, 23, 4, 24),
            intArrayOf(21, 9, 14, 16, 7),
            intArrayOf(6, 10, 3, 18, 5),
            intArrayOf(1, 12, 20, 15, 19)
        )

        val board2 = arrayOf(
            intArrayOf(3, 15, 0, 2, 22),
            intArrayOf(9, 18, 13, 17, 5),
            intArrayOf(19, 8, 7, 25, 23),
            intArrayOf(20, 11, 10, 24, 4),
            intArrayOf(14, 21, 16, 12, 6)
        )

        boardList[0] shouldContainExactly board1
        boardList[1] shouldContainExactly board2
    }



    "Calculate Bingo Score of Last Winning Board" {

        val drawNumbers = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1"

        val boardList =
            listOf(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19",
                "",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6",
                "",
                "14 21 17 24  4",
                "10 16 15  9 19",
                "18  8 23 26 20",
                "22 11 13  6  5",
                "2  0 12  3  7"
            )

        val calculateBingoScore = DayFour().calculateBingoScore(drawNumbers, boardList)
        calculateBingoScore shouldBe 1924
    }
})