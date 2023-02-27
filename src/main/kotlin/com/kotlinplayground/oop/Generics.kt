package com.kotlinplayground.oop

import java.lang.Appendable

class Generics {

    // interface and class declaration with generic
     interface List<E> {
         fun get(index: Int) : E
     }

    // generic functions
    fun <T> List<T>.filter(predicate : (T) -> Boolean) {
        fun use1(ints: List<Int?>) {
            ints.filter { it != null && it > 0 }
        }

        fun use2(strings: List<String?>) {
            strings.filter { !it.isNullOrEmpty() }
        }
    }

    // nullable generic argument
    // fun <T> List<T>.firstOrNull(): T? {}

    // non-nullable upper bound
    fun <T : Any> foo(list: List<T>) {}

    // type parameter constraint
    fun <T: Number> oneHalf(value: T): Double {
        return value.toDouble() / 2.0
    }

    // comparable upper bound
    fun <T: Comparable<T>> max(first: T, second: T): T {
        return  if (first > second) first else second
    }

    // multiple constraints for a type parameter
    fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable {
        if (!seq.endsWith('.')) {
            seq.append('.')
        }
    }

    fun main(args: Array<String>) {
        val ints = listOf(1, 2, 3)
        val i: Int? = ints.firstOrNull()          // 1
        val j: Int? = listOf<Int>().firstOrNull() // null

        oneHalf(13)                         // 6.5

        max(1, 3)                                 // 3

        val helloWorld = StringBuilder("Hello, World")
        ensureTrailingPeriod(helloWorld)
        println(helloWorld)                        // Hello, World.
    }
}