package org.example

object Str {
    fun revert(str: String): String {
        return str.reversed()
    }

    fun isPalindrome(str: String): Boolean {
        return str == revert(str)
    }

    fun vowels(str: String): Int {
        val vowels = "aeiouáéíóúäëïöü"
        var count = 0
        for (char in str) {
            if (vowels.contains(char, true)) {
                count++
            }
        }
        return count
    }

    fun words(str: String): Int {
        return str.split(" ").size
    }

    fun paragraphs(str: String): Int {
        return str.split("\n").size
    }
}