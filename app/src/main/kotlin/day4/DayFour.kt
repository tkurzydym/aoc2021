package day4

class DayFour {

    fun calculateBingoScore(drawNumberInput: String, allBoardsInput: List<String>): Int {
        val drawNumbers = drawNumberInput.split(",").map { it.toInt() }
        val retrieveBoardList = retrieveBoardList(allBoardsInput)

        println("We are playing Bingo now!")

        val drawNumberIterator = drawNumbers.iterator()
        var lastDrawNumber: Int? = null

        val markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
        var winningBoard: Int? = null

        while(winningBoard == null) {
            val nextDrawNumber = if(drawNumberIterator.hasNext()) drawNumberIterator.next() else break

            markDrawnNumberOnBoards(retrieveBoardList, nextDrawNumber, markedNumbersPerBoard)

            winningBoard = getWinningBoard(markedNumbersPerBoard)

            lastDrawNumber = nextDrawNumber
        }

        val unmarkedNumbers =
            getUnmarkedNumbers(retrieveBoardList[winningBoard!!], markedNumbersPerBoard[winningBoard]!!)


        val score = unmarkedNumbers.sum() * lastDrawNumber!!
        println(
            """
            We found our Winning Board which is Number $winningBoard! Congratulations!
            The last drawn Number was $lastDrawNumber with which the Board has won.
            It results in a score of $score for Board $winningBoard!
            """
        )
        return score
    }

    fun retrieveBoardList(allBoards: List<String>): List<Array<IntArray>> {
        val chunkedBoards = allBoards.filter { it.isNotEmpty() }.chunked(5)

        return chunkedBoards.map{ convertStringBoardToIntArray(it)}
    }

    fun convertStringBoardToIntArray(boardAsString: List<String>): Array<IntArray> {

        val board = Array(5) { IntArray(5)}

        boardAsString.forEachIndexed { rowIndex, row ->
            val split = row.split(" ").filter { it.isNotEmpty() }
            split.forEachIndexed { columnIndex, column ->
                board[rowIndex][columnIndex] = column.toInt()
            }
        }

        return board
    }

    private fun markDrawnNumberOnBoards(
        retrieveBoardList: List<Array<IntArray>>,
        nextDrawNumber: Int,
        markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>>
    ) {
        retrieveBoardList.forEachIndexed { boardIndex, board ->
            board.forEachIndexed { rowIdx, row ->
                row.forEachIndexed { columnIdx, column ->
                    if (column == nextDrawNumber) {
                        var markedNumberList = markedNumbersPerBoard[boardIndex]

                        if (markedNumberList == null) {
                            markedNumberList = mutableListOf()
                            markedNumbersPerBoard[boardIndex] = markedNumberList
                        }

                        markedNumberList.add(Pair(rowIdx, columnIdx))
                    }
                }
            }
        }
    }

    private fun getUnmarkedNumbers(boardEntries: Array<IntArray>, markedNumbers: MutableList<Pair<Int, Int>>): List<Int> {

        val nonMarkedNumbers = mutableListOf<Int>()

        boardEntries.forEachIndexed { rowIdx, row ->
            row.forEachIndexed { columnIdx, column ->
                if (!markedNumbers.contains(Pair(rowIdx, columnIdx))) {
                    nonMarkedNumbers.add(column)
                }
            }
        }

        return nonMarkedNumbers
    }

    private fun getWinningBoard(markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>>): Int? {
        markedNumbersPerBoard.forEach{ (key, value) ->
            val rowCount = value.groupingBy { it.first }.eachCount()
            val columnCount = value.groupingBy { it.second }.eachCount()

            if(rowCount.containsValue(5) || columnCount.containsValue(5)) return key
        }

        return null
    }
}
