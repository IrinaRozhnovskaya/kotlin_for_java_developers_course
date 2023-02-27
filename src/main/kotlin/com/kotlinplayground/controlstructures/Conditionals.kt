package com.kotlinplayground.controlstructures

import  com.kotlinplayground.controlstructures.Conditionals.Color.*

class Conditionals {

    // if is an expression
    // val max = if (a > b) a else b
    // No ternary operator in Kotlin

    // when is an analog of switch in Java
    enum class Color {
        BLUE, ORANGE, RED, YELLOW, GREEN, VIOLET, INDIGO
    }

    // No break is needed
    fun getDescription(color: Color): String =
        when (color) {
            BLUE -> "cold"
            ORANGE -> "mild"
            RED -> "hot"
            else -> "--"
        }

    // check when argument equals to one of the values
    fun respondToInput(input: String) = when (input) {
        "y", "yes" -> "I'm glad you are agree"
        "n", "no" -> "Sorry to hear that"
        else -> "I don't understand you"
    }

    // Any expression can be used as a branch condition.
    fun mix(c1: Color, c2: Color) =
        // argument is checked for equality with the brunch conditions
        when(setOf(c1,c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }

    // checking types Pet <- Cat
    //                    <- Dog
//    fun getSound(): String =
//        when (val pet = getMyFavouritePet()) {
//            // is = instanceof in Java, smart cast of pet to Cat or Dog
//            is Cat -> pet.meow()
//            is Dog -> pet.woof()
//            else -> "--"
//    }

    // checking conditions, when without argument
    fun updateWeather(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> "cold" to BLUE
            degrees < 23 -> "mild" to ORANGE
            else -> "hot" to RED
        }
    }
}