package day6

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class DaySixTest: StringSpec({

    "keep track of lanternfish lifecycles for 80 Days" {

        val input = mutableListOf(3,4,3,1,2)
        val count = DaySix().countOfLanternfishesAfterDays(input, 80)

        count shouldBe 5934
    }


    "keep track of lanternfish lifecycles for 256 Days" {

        val input = mutableListOf(3,4,3,1,2)
        val count = DaySix().countOfLanternfishesAfterDays(input, 256)

        count shouldBe 26984457539
    }

})