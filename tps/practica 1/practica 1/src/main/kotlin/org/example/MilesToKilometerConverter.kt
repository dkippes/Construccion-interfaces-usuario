package org.example

class MilesToKilometerConverter : Convertible {
    private val kilometers = 1.60934
    override fun convert(value: Double): Double {
        return value * kilometers
    }
}