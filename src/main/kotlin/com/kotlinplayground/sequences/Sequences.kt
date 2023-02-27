package com.kotlinplayground.sequences

import kotlin.random.Random

class Sequences {
    // sequences can be compared with streams in Java
    interface Sequence<out T> {
    }

    val list = listOf(1, 2, -3)
    val maxOddSquare = list
        .asSequence()
        .map { it * it }
        .filter { it % 2 == 1 }
        .max()

    // operations on collections -> eager (horizontal) evaluation
    // operations on sequences -> lazy (vertical) evaluation -> avoid creating intermediate collections
    fun m(i: Int): Int {
        print("m$i ")
        return i
    }

    fun f(i: Int): Boolean {
        print("f$i ")
        return i % 2 == 0
    }

    fun main(args: Array<String>) {
        val list = listOf(1, 2, 3, 4)
        list.map(::m).filter(::f)                       // m1 m2 m3 m4 f1 f2 f3 f4
        list.asSequence().map(::m).filter(::f).toList() // m1 f1 m2 f2 m3 f3 m4 f4
        list.asSequence().map(::m).filter(::f)          // nothing happens until the terminal operation is called
        // the order of operations is important
        list.asSequence().filter(::f).map(::m).toList() // f1 f2 m2 f3 f4 m4

        // generating a sequence
        generateSequence { Random.nextInt() }

        val input = generateSequence {
            readLine().takeIf { it != "exit" }
        }
        println(input.toList())                // a, b, exit -> [a, b]

        val numbers = generateSequence(0) { it + 1 }
        numbers.take(5).toList()            // [0, 1, 2, 3, 4]

        // yield
//        sequence {
//            yield(value)
//            yieldAll(list)
//            yieldAll(sequence)
//        }
        val otherNumbers = sequence {
            var x = 0
            while (true) {
                yield(x++)
            }
        }
        otherNumbers.take(5).toList()       // [0, 1, 2, 3, 4]
    }
}