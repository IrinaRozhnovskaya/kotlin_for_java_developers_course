package com.kotlinplayground.inlinefunctions

import java.io.BufferedReader
import java.io.FileReader
import java.nio.file.FileVisitResult
import java.nio.file.Path
import java.util.concurrent.locks.Lock

class InlineFunctions {

    // Under the hood lambdas should be inlined -> no performance overhead - compiler substitutes a body of the function
    // instead of calling it
    inline fun <R> run(block: () -> R): R = block()
    val name = "Kotlin"

    // run function runs the block of code (lambda) and returns the last expression as a result
    val foo = run {
        println("Calculating foo")
        "foo"
    }

    // let function allows to check the argument for being non-null, not only the receiver

//    fun getEmail() : Email?
//    val email = getEmail()
//    if (email != null) sendEmailTo(email) or
//    email?.let { e -> sendEmailTo(e)}
//    getEmail()?.let { sendEmailTo(it) }
//}

    // takeIf function returns the receiver object if it is satisfies the given predicate, otherwise returns null
    val number = 42
    val other = 4

    // using takeIf in chain call
//    issues.filter{ it.status == OPEN }
//          .takeIf{ List<Issue>::isNotEmpty }
//          ?.let { println("There are some open issues") }

    // takeUnless function returns the receiver object if it does not satisfy the given predicate, otherwise returns null
    inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? =
        if (!predicate(this)) this else null

    fun foo(number: Int) {
        val result = number.takeUnless { it < 10 }
        // generated code
        // val result = if (!(number < 10)) number else null - inlined code of lambda body
    }

    // repeat function repeats an action for a given number of times

    // inlining of synchronized
    inline fun <T> synchronized(lock: Lock, action: () -> T): T {
        lock.lock()
        try {
            return action()
        } finally {
            lock.unlock()
        }
    }

    fun sync(lock: Lock) {
        synchronized(lock) {
            println("Action")
            // generated code
//            lock.lock()
//            try {
//                println("Action")
//            } finally {
//                lock.unlock()
//            }
        }
    }

    // withLock function
//    val l: Lock = ...
//            l.withLock{
//                // access the resources defined by this lock
//            }

    inline fun <T> Lock.withLock(action: () -> T): T {
        lock()
        try {
            return action()
        } finally {
            unlock()
        }
    }

    // resource management: use function
    fun readFirstLineFromFile(path: String): String {
        BufferedReader(FileReader(path)).use { br ->   // analog of try with resources in Java
            return br.readLine()
        }
    }

    // Extensions on collections are inlined (filter, map, any, find, groupBy ...) -> no performance overhead,
    // but intermediate collections are created for a chained calls -> using sequences

    // filter function
    inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
        val destination = ArrayList<T>()
        for (element in this) {
            if (predicate(element)) {
                destination.add(element)
            }
        }
        return destination
    }

    fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

    fun main(args: Array<String>) {
        run { println("Hi $name!") }  // inlined code of lambda body println("Hi $name!")
        number.takeIf { it > 10 }     // 42
        other.takeIf { it > 10 }      // null
        repeat(10) {
            println("Welcome!")
        }
    }
}
