package com.kotlinplayground.functionalprogramming

class Lambdas {
    fun containsZero(list: List<Int>): Boolean {
        list.forEach {
            if (it == 0) return true // return from fun NOT forEach
        }
        return false
    }

    fun duplicateNonZero(list: List<Int>) {
        list.flatMap {
            if (it == 0) return@flatMap listOf<Int>() // return from flatMap
            listOf(it, it)
        }
    }

    fun main(args: Array<String>) {
        duplicateNonZero(listOf(3, 0, 5)) // [3, 3, 5, 5]
    }
}