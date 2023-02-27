package com.kotlinplayground.extensions

import com.kotlinplayground.controlstructures.Conditionals.Color.*

class StandardLibraryExtensions {
    // Kotlin standard library = Java standard library + extensions
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven",
            53 to "fifty-three")
    val sum = listOf(1, 2, 3).sum()

    // Multiline string template
    val q = """To code,
        |or not to code""".trimMargin()
//    val q = """To code,
//        #or not to code""".trimMargin("#")
    val a = """
        Keep calm
        and learn Kotlin
   """.trimIndent()

    // Regular expression
    val regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()


    // Kotlin's library: extensions on collections
    // list.max(), filter, map, reduce, count, find, any, flatMap, groupBy, ...

//    fun <T> Iterable<T>.joinToString(
//        separator: CharSequence = ",",
//        prefix: CharSequence = "",
//        postfix: CharSequence = ""
//    ) : String

//    fun <T> Array<T>.getOrNull(index: Int) =
//        if (index in 0 until size) this[index] else null
//    and the same for List
//    fun <T> List<T>.getOrNull(index: Int) =
//        if (index in 0 until size) this[index] else null

//    fun <T> Iterable<T>.withIndex(): List<IndexedValue<T>> {...}

//    infix fun Int.until(to: Int): IntRange

//    fun Char.isLetter() = this in 'a'..'z' || this in 'A'..'Z'

//    fun Char.isLetterOrDigit() = isLetter() || this in '0'..'9'

//    infix fun <A, B> A.to(that: B) = Pair(this, that)
//    data class Pair<A, B>(val first: A, val second: B) {
//        override fun toString(): String = "($first, $second)"
//    }
//
//    val pair: Pair<Char, Double> = 'a' to 1.0

    infix fun <T> T.eq(other: T) {
        if (this == other) println("OK")
        else println("Error: $this != $other")
    }

    fun getAnswer() = 42

    fun List<Int>.sum(): Int {
        var result = 0
        for (i in this) {
            result += i
        }
        return result
    }

    fun main(args: Array<String>) {
        println(set.javaClass) // class java.util.HashSet
        println(list.javaClass) // class java.util.ArrayList
        println(map.javaClass) // class java.util.HashMap
        println(listOf('a', 'b', 'c').joinToString("", "(", ")")) // (abc)
        println("Hello, ${args.getOrNull(0)}!")
        println(list.getOrNull(0)) // 1
        println(list.getOrNull(3)) // null
        for ((index, element) in list.withIndex()) {
            println("$index $element")
        }
        1.until(10)
        1 until 10
        "Answer".to(42)
        "hot" to RED
        mapOf(0 to "zero", 1 to "one")
        'a'.isLetter() // true
        '%'.isLetterOrDigit() // false
        regex.matches("15.02.2022") // true
        regex.matches("15.02.22") // false
        // conversion String to numbers
        "123".toInt() // 123
        "1e-10".toDouble() // 1.0E-10
        "xx".toInt() // NumberFormatException
        "xx".toIntOrNull() // null
        getAnswer() eq 42 // OK
        getAnswer() eq 43 // ERROR: 42 != 43
        println(sum)    // 6
    }
}