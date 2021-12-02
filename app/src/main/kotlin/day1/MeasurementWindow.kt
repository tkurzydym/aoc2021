package day1

data class MeasurementWindow(val first: Int, val second: Int, val third: Int) {
    fun sum(): Int {
        return first + second + third
    }
}