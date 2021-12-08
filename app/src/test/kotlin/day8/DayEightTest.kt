package day8

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class DayEightTest: StringSpec({

    "Count only unique digits" {
        DayEight().countUniqueDigitsInOutput(
            listOf(
                "fdgacbe cefdb cefbgd gcbe",
                "fcgedb cgb dgebacf gc",
                "cg cg fdcagb cbg",
                "efabcd cedba gadfec cb",
                "gecf egdcabf bgf bfgea",
                "gebdcfa ecba ca fadegcb",
                "cefg dcbef fcge gbcadfe",
                "ed bcgafe cdgba cbgef",
                "gbdfcae bgc cg cgb",
                "fgae cfgab fg bagce"
            )
        ) shouldBe 26
    }
})