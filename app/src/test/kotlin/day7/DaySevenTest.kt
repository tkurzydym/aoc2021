package day7

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class DaySevenTest: StringSpec({
    "Calculate lowest fuel consumption"{

        val input = "16,1,2,0,4,2,7,1,2,14"
            .split(",")
            .map { it.toInt() }
            .toList()

        val lowestPossibleConsumption = DaySeven().lowestFuelConsumption(input)

        lowestPossibleConsumption shouldBe 168
    }
})