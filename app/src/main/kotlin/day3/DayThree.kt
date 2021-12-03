package day3

class DayThree {

    fun calculatePowerConsumption(input: List<String>): Int {
        println("We got to figure out the power consumption!")

        val diagnosticReport = convertDiagnosticReport(input)

        var gammaRate = ""
        var epsilonRate = ""

        diagnosticReport.values.forEach {
            val mostCommonPair = getMostCommonPair(it)
            gammaRate += mostCommonPair.first
            epsilonRate += mostCommonPair.second
        }

        val powerConsumption = gammaRate.toInt(2) * epsilonRate.toInt(2)

        println(
            """
            We have calculated a gamma rate of $gammaRate
            and an epsilon rate of $epsilonRate
            Therefore we have a power consumption of $powerConsumption
            """
        )

        return powerConsumption
    }

    private fun convertDiagnosticReport(
        input: List<String>
    ): MutableMap<Int, MutableList<Int>> {
        val commonMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        input.forEach {
            it.toCharArray().forEachIndexed { idx, value ->
                var mutableList = commonMap[idx]

                if (mutableList == null) {
                    mutableList = mutableListOf()
                    commonMap[idx] = mutableList
                }

                mutableList.add(Character.getNumericValue(value))
            }
        }
        return commonMap
    }

    private fun getMostCommonPair(list: MutableList<Int>): Pair<Int, Int> {
        val eachCount = list.groupingBy { it }.eachCount()
        val mostCommon = eachCount.maxByOrNull { it.value }!!.key
        val mostUncommon = eachCount.minByOrNull { it.value }!!.key

        return Pair(mostCommon, mostUncommon)
    }

    fun calculateLifeSupportRating(input: List<String>): Int {
        println("And now we want to figure out the Life Support Rating!")
        val oxygenRating = extractLifeRatingValue(input.toMutableList(),
            true)

        val co2Rating = extractLifeRatingValue(
            input.toMutableList(),
        false)

        val lifeSupportRating = oxygenRating.toInt(2) * co2Rating.toInt(2)

        println(
            """
            We have an Oxygen Rating of ${oxygenRating.toInt(2)}
            We have a C02 Rating of ${co2Rating.toInt(2)}
            Therefore, our Life Support Rating is at $lifeSupportRating
            """
        )

        return lifeSupportRating
    }

    private fun extractLifeRatingValue(
        input: MutableList<String>,
        isMostCommon: Boolean
    ): String {
        var possibleRatingValue: MutableList<String> = input.toMutableList()

        var currentPosition = 0

        while (possibleRatingValue.size > 1) {
            val convertDiagnosticReport = convertDiagnosticReport(possibleRatingValue)

            val mostCommon = getMostCommonForCurrentPosition(
                convertDiagnosticReport, currentPosition, isMostCommon
            )

            possibleRatingValue = findMatchingInputValues(
                possibleRatingValue,
                mostCommon,
                currentPosition
            )

            currentPosition++
        }

        return possibleRatingValue[0]
    }

    private fun getMostCommonForCurrentPosition(
        convertDiagnosticReport: MutableMap<Int, MutableList<Int>>,
        currentPosition: Int,
        isMostCommon: Boolean
    ): Int {
        val eachCount = convertDiagnosticReport[currentPosition]!!
            .groupingBy { it }
            .eachCount()

        if(eachCount.values.first() == eachCount.values.last()) {
            return if(isMostCommon) 1 else 0
        }

        val mostCommon = eachCount.maxByOrNull { it.value }!!.key
        val mostUncommon = eachCount.minByOrNull { it.value }!!.key

        return if(isMostCommon) mostCommon else mostUncommon
    }

    private fun findMatchingInputValues(
        listToFilter: MutableList<String>,
        mostCommon: Int,
        key: Int
    ): MutableList<String> {
        return listToFilter
            .filter { Character.getNumericValue(it.toCharArray()[key]) == mostCommon }
            .toMutableList()
    }

}
