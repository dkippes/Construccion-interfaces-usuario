package org.example

import kotlin.math.pow

object UIList {
    fun isSorted(list: List<Int>): Boolean {
        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) {
                return false
            }
        }
        return true
    }

    fun sortListBy(list: List<Int>, asc : Boolean) : List<Int> {
        return if (asc) {
            list.sorted()
        } else {
            list.sortedDescending()
        }
    }

    fun filterPrimes(list: List<Int>): List<Int> {
        return list.filter { isPrime(it) }
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) {
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    fun powMap(list: List<Int>): List<Int> {
        return list.map { it.toDouble().pow(2).toInt() }
    }

    fun sumProdPos(list: List<Int>): Int {
        var contador = 0
        for ((index, value) in list.withIndex()) {
            contador += value * (index + 1)
        }
        return contador
    }
}