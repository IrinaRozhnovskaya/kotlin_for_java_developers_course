package com.kotlinplayground.controlstructures

import java.io.IOException

class Exceptions {
    // No difference between checked and unchecked exceptions
    // In Kotlin you may or may not handle any exception

    // throw is an expression
//    val percentage =
//        if (number in 0..100)
//            number
//    else
//        throw IllegalArgumentException(
//            "A percentage value must be" +
//                "between 0 and 100: $number")

    // try is an expression
//    val number = try {
//        Integer.parseInt(string)
//    } catch (e: NumberFormatException) {
//        null
//    }

    // @Throws annotation for using by Java
    @Throws(IOException::class)
    fun foo() {
        throw IOException()
    }
}