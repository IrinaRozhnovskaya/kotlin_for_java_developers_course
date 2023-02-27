package com.kotlinplayground.oop

import com.kotlinplayground.oop.ClassModifiers.Light.*
import com.kotlinplayground.oop.ClassModifiers.Color.*

class ClassModifiers {
    // enum class
    enum class Light {
        WHITE, YELLOW
    }

    fun getDescription(light: Light) =
        when (light) {
           WHITE -> "cold"
           YELLOW -> "mild"
        }

    // enum class with properties
    enum class Color(
        val r: Int, val g: Int, val b: Int
    ) {
        BLUE(0, 0, 255), ORANGE(225, 1655, 0), RED(255, 0 ,0);

        fun rgb() = (r * 256 + g) * 256 + b
     }

    // data class

    // data modifiers generates methods: equals, hashCode, copy, toString and some others

    // copying the instance
    data class Contact(val name: String, val address: String)
    // specify only the arguments that must be changed, the rest values remain the same
    //  contact.copy(address = "new address")

    // equals and reference equality
    val set1 = setOf(1, 2, 3)
    val set2 = setOf(1, 2, 3)

    // sealed class

    // class hierarchy
    // sealed restricts class hierarchy: all subclasses must be located in the same file
    sealed class Expr // under the hood sealed class has private default constructor
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()

    fun eval(e: Expr) : Int = when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
    }

    fun main(args: Array<String>) {
        println(BLUE.r)                      // 0
        println(BLUE.rgb())                  // 225

        set1 == set2                         // true -> == calls equals (default equals checks reference equality,
                                             // generated (in data class) - compare content)
        set1 === set2                        // false -> === checks reference equality

    }

    // nested and inner class
    // nested -> static class, inner -> non-static class, that stores the reference to outer class
    class A // nested class is static by default (static class A - in Java)
    inner class B // class B is inner by default in Java

    // inner modifier adds reference to the outer class
//    class A {
//        class B
//        class C {
//            ...this@A...
//        }
//    }

    // class delegation
    class Customer

    interface Repository {
        fun getById(id: Int): Customer
        fun getAll(): List<Customer>
    }

    interface Logger {
        fun logAll()
    }
    class Controller(
        val repository: Repository,
        val logger: Logger
    ) : Repository by repository, Logger by logger // implements an interface by delegating to
//     {
//         override fun getById(id: Int) = repository.getById(id)
//         override fun getAll() = repository.getAll()
//         override fun logAll() = logger.logAll()
//         }
}
