package com.kotlinplayground.functionalprogramming

class FunctionTypes {

    // Lambda takes Int as a parameters and returns Int as a result
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    // Note the difference between storing a Lambda and storing the result of applying this Lambda. Lambda is the whole
    // function containing the logic of how to compute the Boolean result from the given Int argument, while the result
    // is simply a Boolean value
    val isEven: (Int) -> Boolean = { i -> i % 2 == 0 }

    val list = listOf(1, 2, 3, 4)

    fun main(args: Array<String>) {
        // calling stored function
        // to call a Lambda stored in a variable might be convenient if you want to postpone calling a Lambda,
        // store somewhere and call it on the later
        val result: Boolean = isEven(42) // true

        // passing a variable of function type as an argument
        list.any(isEven) // true
        list.filter(isEven) // [2, 4]

        // calling lambda directly
        run { println("hey!") }

        // return type is nullable
        val f1: () -> Int? = { null }

        // the variable is nullable
        val f2: (() -> Int)? = null

        // working with a nullable function type
        f2?.invoke()
    }
}