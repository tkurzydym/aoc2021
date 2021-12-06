package day6

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class DaySixTest: StringSpec({

    "keep track of lanternfish lifecycles" {

        val input = mutableListOf(3,4,3,1,2)
        val count = DaySix().countOfLanternfishesAfter80Days(input)

        count shouldBe 5934
    }

})