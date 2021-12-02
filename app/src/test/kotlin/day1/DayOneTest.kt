package day1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DayOneTest : StringSpec({
    "single measurement increased count" {
        DayOne().calculateIncreasedValues(
            intArrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        ) shouldBe 7
    }

    "measurement window increased count " {
        DayOne().calculateAmountMeasurementWindowsIncreased(
            intArrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        ) shouldBe 5
    }
})