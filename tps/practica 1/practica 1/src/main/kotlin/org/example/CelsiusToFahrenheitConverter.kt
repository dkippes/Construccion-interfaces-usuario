package org.example

class CelsiusToFahrenheitConverter : Convertible {
    private val fahrenheit = 1.8
    private val fahrenheitOffset = 32
    override fun convert(value: Double): Double {
        return value * fahrenheit + fahrenheitOffset
    }
}