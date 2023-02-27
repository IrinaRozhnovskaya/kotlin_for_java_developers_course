package com.kotlinplayground.types

class BasicTypes {

    // In Kotlin there are not primitive and reference types.
    // Only Int and nullable Int?, the same applies to Double and Boolean
    fun foo(): Int = 1     // corresponds to a primitive int in Java
    fun bar(): Int? = 1    // corresponds to java.lang.Integer

    // generic arguments
//    List<Int> -> List<Integer> in Java

    // arrays
//    Array[Int] -> Integer[] in Java

    // array of primitives
//    IntArray -> int[] in Java

    // Any -> java.lang.Object, but it is supertype not only for reference, but for Int and so on

    // boxing under the hood
    fun log(any: Any) {
        println("Value: $any")
    }

    // function types
//        Kotlin                 Java
//    () -> Boolean     - Function0<Boolean>
//    (Order) -> Int    - Function1<Order, Int>
//    (Int, Int) -> Int - Function2<Int, Int, Int>

    // arrays comparison
    val inst1 = listOf(1, 2)
    val inst2 = listOf(1, 2)

    fun main(args: Array<String>) {

    // kotlin.String = java.lang.String, but hides some confusing methods
        //"one.two.".replaceAll(".", "*") in Java             // ********
        "one.two.".replace(".", "*")         // one*two*
        "one.two.".replace(".".toRegex(), "*")     // ********

        log(2023) // int is outboxed

        println(inst1 == inst2)                               // false (checks reference equality)
        // println(inst1.contentEquals(inst2))                // true (needed to create extension function for that)
    }
}