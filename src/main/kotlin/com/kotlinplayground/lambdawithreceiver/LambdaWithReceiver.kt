package com.kotlinplayground.lambdawithreceiver

class LambdaWithReceiver {

    // Extension function & Lambda -> Lambda with receiver

    // with function
    inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

//    val sb = StringBuilder()
//    sb.appendln("Alphabet:")
//    for (c in 'a'..'z') {
//        sb.append(c)
//    }
//    sb.toString      ->

//    val sb = StringBuilder()
//    with (sb) {                     // lambda
//        this.appendln("Alphabet:")  // this is receiver of lambda, as usual this can be omitted
//        for (c in 'a'..'z') {
//            this.append(c)
//        }
//        this.toString
//    }

    // run function like with, but extension

//    val windowOrNull = windowById["main"]
//    windowOrNull?.run {
//        width = 300
//        height = 200
//        isVisible = true
//    }

    // apply function returns receiver as a result

//    windowById["main"]?.apply {
//            width = 300
//            height = 200
//            isVisible = true
//    } ?: return

    // also function like apply, but has regular argument this instead of this

//    val mainWindow =
//        windowById["main"]?.apply {
//            width = 300
//            height = 200
//            isVisible = true
//    } ?: also {
//           showWindow(it)
//    }

    // extension function vs lambda with receiver

    // extension function
    fun String.lastChar() = get(length -1)

    // lambda with receiver
    // buildString {
        //         append("...")

    // }

    // regular lambda vs lambda with receiver

    // regular lambda
    val isEven: (Int) -> Boolean = { it % 2 == 0}

    // lambda with receiver
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }

    fun main(args: Array<String>) {
        isEven(0)               // calling as a regular function
        1.isOdd()               // calling as an extension function
    }
}