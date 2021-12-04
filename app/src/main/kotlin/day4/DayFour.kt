package day4

class DayFour {

    fun calculateBingoScore(drawNumberInput: String, allBoardsInput: List<String>): Int {
        val drawNumbers = drawNumberInput.split(",").map { it.toInt() }
        val retrieveBoardList = retrieveBoardList(allBoardsInput)

        println("We are playing Bingo now!")

        val drawNumberIterator = drawNumbers.iterator()

        val markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
        var winningBoards: MutableList<Pair<Int, Int>> = mutableListOf()

        while(drawNumberIterator.hasNext()) {
            val nextDrawNumber = drawNumberIterator.next()

            markDrawnNumberOnBoards(retrieveBoardList, nextDrawNumber, markedNumbersPerBoard, winningBoards)

            addWinningBoard(winningBoards, markedNumbersPerBoard, nextDrawNumber)
        }

        val firstWinningBoard = winningBoards.first()
        val unmarkedNumbersOfFirstWinningBoard =
            getUnmarkedNumbers(retrieveBoardList[firstWinningBoard.first], markedNumbersPerBoard[firstWinningBoard.first]!!)
        val scoreOfFirstWinningBoard = unmarkedNumbersOfFirstWinningBoard.sum() * firstWinningBoard.second

        val lastWinningBoard = winningBoards.last()
        val unmarkedNumbersOfLastWinningBoard =
            getUnmarkedNumbers(retrieveBoardList[lastWinningBoard.first], markedNumbersPerBoard[lastWinningBoard.first]!!)
        val scoreOfLastWinningBoard = unmarkedNumbersOfLastWinningBoard.sum() * lastWinningBoard.second

        println(
            """
            We found our Winning Board which is Number ${firstWinningBoard.first + 1}! Congratulations!
            The last drawn Number was ${firstWinningBoard.second} with which the Board has won.
            It results in a score of $scoreOfFirstWinningBoard for Board ${firstWinningBoard.first + 1}!
            
            Sadly we also found our Board that wins last which is Number ${lastWinningBoard.first + 1}! Sorry for you!
            The last drawn Number was ${lastWinningBoard.second} with which the Board has won.
            It results in a score of $scoreOfLastWinningBoard for Board ${lastWinningBoard.first + 1}!
            """
        )
        return scoreOfLastWinningBoard
    }

    private fun addWinningBoard(
        winningBoards: MutableList<Pair<Int, Int>>,
        markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>>,
        nextDrawNumber: Int) {

        val boardsThatWonThisRound = getWinningBoards(winningBoards, markedNumbersPerBoard)
        boardsThatWonThisRound.forEach {
            winningBoards.add(Pair(it, nextDrawNumber))
        }
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
        markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>>,
        winningBoards: MutableList<Pair<Int, Int>>
    ) {
        val boardKeysThatWon = winningBoards.map { it.first }
        retrieveBoardList
            .forEachIndexed { boardIndex, board ->
                if(!boardKeysThatWon.contains(boardIndex)){
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

    private fun getWinningBoards(
        boardsThatAlreadyWon: List<Pair<Int, Int>>,
        markedNumbersPerBoard: MutableMap<Int, MutableList<Pair<Int, Int>>>
    ): List<Int> {
        val boardsThatWonThisRound: MutableList<Int> = mutableListOf()
        val boardKeysThatWon = boardsThatAlreadyWon.map { it.first }
        markedNumbersPerBoard
            .filter { (key, _) -> !boardKeysThatWon.contains(key) }
            .forEach { (key, value) ->
                val rowCount = value.groupingBy { it.first }.eachCount()
                val columnCount = value.groupingBy { it.second }.eachCount()

                if (rowCount.containsValue(5) || columnCount.containsValue(5)) {
                    boardsThatWonThisRound.add(key)
                }
            }

        return boardsThatWonThisRound
    }
}
