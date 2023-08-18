package org.example

import java.time.LocalDate

fun main(args: Array<String>) {
    println("Ejercicio 1")
    println("KilometerToMilesConverter().convert(1.0) = ${GenericConverter(KilometerToMilesConverter()).convert(1.0)}")
    println("MilesToKilometerConverter().convert(1.0) = ${GenericConverter(MilesToKilometerConverter()).convert(1.0)}")
    println("CelsiusToFahrenheitConverter().convert(1.0) = ${GenericConverter(CelsiusToFahrenheitConverter()).convert(1.0)}")

    println("Ejercicio 2")
    println("Str.reverse() = ${Str.revert("interfaces")}")
    println("Str.isPalindrome() = ${Str.isPalindrome("neuquen")}")
    println("Str.vowels() = ${Str.vowels("Ácido clorhídrico")}")
    println("Str.words() = ${Str.words("construcción de interfaces de usuario")}")
    println("Str.paragraphs() = ${Str.paragraphs("Hola soy pepe.\n Como estas?")}")

    println("Ejercicio 3")
    val diego = User("Diego Kippes", "dkippes", "dkippes@gmail.com", LocalDate.of(1995, 10, 10))
    val tita = User("Leandro Titareli", "ltita", "ltita@yahoo.com", LocalDate.of(1900, 10, 5))
    diego.follow(tita)
    tita.follow(diego)
    println("diego.age() = ${diego.age()}")
    println("diego.isGmail() = ${diego.isGmail()}")
    println("diego.getFollowersIFollow() = ${diego.getFollowersIFollow()}")
    println("tita.age() = ${tita.age()}")
    println("tita.isGmail() = ${tita.isGmail()}")
    println("tita.getFollowersIFollow() = ${tita.getFollowersIFollow()}")

    println("Ejercicio 4")
    val list = listOf(1, 1, 2, 3, 5, 8)
    println("UIList.isSorted() = ${UIList.isSorted(list)}")
    println("UIList.sortListBy(true) = ${UIList.sortListBy(list, true)}")
    println("UIList.sortListBy(false) = ${UIList.sortListBy(list, false)}")
    println("UIList.filterPrimes() = ${UIList.filterPrimes(list)}")
    println("UIList.powMap() = ${UIList.powMap(list)}")
    println("UIList.sumProdPos() = ${UIList.sumProdPos(list)}")
}

