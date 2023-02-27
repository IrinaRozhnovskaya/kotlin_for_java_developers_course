package com.kotlinplayground.controlstructures

class Ranges {

    // iteration
    // for (i in 'a'..'z') {}

    // check for belonging
    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    // not in a range
    fun isNotDigit(c: Char) = c !in '0'..'9'

    // in as when-condition
    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know ..."
    }

    // Different ranges
    val intRange: IntRange = 1..9

    val anotherIntRange = 1 until 10
    val charRange: CharRange = 'a'..'z'
    val stringRange: ClosedRange<String> = "ab".."az"
    // val dateRange: ClosedRange<MyDate> = startDate..endDate

    // range of custom types
//    class MyDate : Comparable<MyDate>
//
//    if (myDate in startDate..endDate) {...}

    // belonging to collection
    // if (element in list) {...}

    // the same as
    // if (list.contains(element)) {...}

    // Implement the function that checks whether a string is a valid identifier. A valid identifier is a non-empty
    // string that starts with a letter or underscore and consists of only letters, digits and underscores.
    fun isValidIdentifier(s: String): Boolean {
        fun isValidCharacter(ch: Char) =
            ch == '_' || ch.isLetterOrDigit()
        if (s.isEmpty() || s[0].isDigit()) return false
        for (ch in s) {
            if (!isValidCharacter(ch)) return false
        }
        return true
    }

    fun main(args: Array<String>) {
        println(isValidIdentifier("name"))   // true
        println(isValidIdentifier("_name"))  // true
        println(isValidIdentifier("_12"))    // true
        println(isValidIdentifier(""))       // false
        println(isValidIdentifier("012"))    // false
        println(isValidIdentifier("no$"))    // false
    }
}
