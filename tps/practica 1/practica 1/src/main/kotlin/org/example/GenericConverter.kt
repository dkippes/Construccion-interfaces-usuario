package org.example

class GenericConverter(private var converter: Convertible) {
    fun convert(value: Double): Double {
        return converter.convert(value)
    }
}