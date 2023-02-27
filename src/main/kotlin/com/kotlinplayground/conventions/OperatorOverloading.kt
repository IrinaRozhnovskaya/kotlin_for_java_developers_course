package com.kotlinplayground.conventions

class OperatorOverloading {

    // arithmetic operations
    class Point(val x: Int, val y: Int)

    operator fun Point.plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    // expression - function name
    //   a + b    -    plus
    //   a - b    -   minus
    //   a * b    -   times
    //   a / b    -    div
    //   a % b    -    mod

    // no restrictions on parameter type
    operator fun Point.times(scale: Int): Point {
        return Point(x * scale, y * scale)
    }

    // unary operations
    operator fun Point.unaryMinus() = Point(-x, -y)

    // expression - function name
    //   +a       -   unaryPlus
    //   -a       -   unaryMinus
    //   !a       -      not
    // ++a, a++   -      inc
    // --a, a--   -      dec

    // assignment operations
    // a += b -> a = a.plus(b) for mutable or -> a.plusAssign(b)

    // conventions for lists
    val list = listOf(1, 2, 3)
    val mutableList = mutableListOf(1, 2, 3)

    fun main(args: Array<String>) {
        Point(1, 2) + Point(2, 3)
        Point(1, 2) * 3
        -Point(3, 4)

        val newList = list + 2
        mutableList += 4
    }
}