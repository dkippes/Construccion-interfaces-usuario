package org.example

class KilometerToMilesConverter : Convertible {
    private val miles = 1.60934
    override fun convert(value: Double): Double {
        return value / miles
    }
}