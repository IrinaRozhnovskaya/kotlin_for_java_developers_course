package com.kotlinplayground.conventions

class Conventions {

    // comparisons
    // "abc" < "dfe"
    // myComparable1 >= myComparable2

    // a > b -> a.compareTo(b) > 0
    // a < b -> a.compareTo(b) < 0
    // a >= b -> a.compareTo(b) >= 0
    // a <= b -> a.compareTo(b) <= 0

    // equality check
    // s1 == s2 calls s1.equals(s2)

    fun main(args: Array<String>) {
        null == "abc" // false
        null == null  // true
    }

    // accessing elements by index: []
    // map[key]
    // mutableMap[key] = newValue
    // x[a, b]  -> x.get(a, b)
    // x[a, b] = c  -> x.set(a, b, c)

//    class Board
//    operator fun Board.get(x: Int, y: Int): Char { ... }
//    operator fun Board.set(x: Int, y: Int, value: Char){ ... }
//
//    board[1, 2] = 'x'
//    board[1, 2]  // 'x'

    // in convention
//    if (key in map) {}
//    if (element in list) {}
//    a in c -> c.contains(a)

    // rangeTo conventions
//    if (s in "abc".."dfe") {}
//    for (i in 1..2) {}
//
//    val oneTo100: IntRange = 1..100
//    for (i in oneTo100) {}
//
//    start..end -> start.rangeTo(end)

    // iterator convention
//    operator fun CharSequence.iterator(): CharIterator
//    for (c in "abc") {}

    // destructing declaration
//    val (first, second) = pair -> val first = pair.component1()
//                                  val second = pair.component2()
//
//    for ((key, value) in map) {} -> for (entry in map) {
//                                       val key = entry.component1()
//                                       val value = entry.component2()
//                                    }
//
//    map.forEach{ (key, value) -> } -> map.forEach { argument ->
//                                        val key = entry.component1()
//                                        val value = entry.component2()
//                                      }

    // destructing in lambdas
//    one parameter -> { a -> ... }
//    two parameters -> { a, b -> ... }
//    destructured pair -> { (a, b) -> ... }
//    destructured pair and another parameter -> { (a, b), c -> ... }

    // destructured declaration and data classes
    data class Contact(
        val name: String,
        val email: String,
        val phoneNumber: String
    )

    // val (name, _, phoneNumber) = contact

    data class Pair<A, B>(val first: A, val second: B)
    data class IndexedValue<T>(val index: Int, val value: T)

    // compareTo convention
    // private operator fun Point.compareTo(other: Point): Int {}
    // the operator syntax works only when the private operator is visible
}