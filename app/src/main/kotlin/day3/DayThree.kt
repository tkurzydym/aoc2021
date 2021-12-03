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

}
