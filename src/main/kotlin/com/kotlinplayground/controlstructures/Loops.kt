package com.kotlinplayground.controlstructures

class Loops {
    // while loops are the same as in Java
//    while (condition) {
//        /*....*/
//    }

//    do {
//        /*....*/
//    } while (condition)

    // for loop
    val list = listOf("a", "b", "c")
    // can be used without element type
//    for (s: String in list) {
//        print(s) // abc
//    }

    // iterating over map
    val map = mapOf(1 to "one",
                    2 to "two",
                    3 to "three")
//    for ((key, value) in map) {
//        println("$key = $value") // 1 = one
//                                 // 2 = two
//                                 // 3 = three
//    }

    // iterating with index over collection
    val iList = listOf("a", "b", "c")
//    for ((index, element) in iList.withIndex()) {
//        println("$index: $element") // 0: a
//                                    // 1: b
//                                    // 2: c
//    }

    // iterating over range
//    for (i in 1..9) {
//        print(i) // 123456789
//    }

    // until excludes upper bound
//    for (i in 1 until 9) {
//        print(i) // 12345678
//    }

    // iterating with a step
//    for (i in 9 downTo 1 step 2) {
//        print(i) // 97531
//    }

    // iterating over String
//    for (ch in "abc") {
//        print(ch + 1) // bcd
//    }
}