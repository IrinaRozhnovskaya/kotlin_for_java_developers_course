package com.kotlinplayground.oop

class Object {
    // object = singleton in Java
    object KSingleton {
        fun foo() {}
    }

    // companion object - special object inside a class, which members can be accessed by the class name
    // companion objects might be a replacement for a static methods in Java
    class A {
        companion object {
            fun foo() = 1
        }
    }

    // companion object can implement interface
    interface Factory<T> {
        fun create() : T
    }
     class B {
         private constructor()
         companion object : Factory<B> {
             override fun create(): B {
                 return B()
             }
         }
     }

    // companion object can be a receiver of extension function
//    class Person(val firstName: String, val lastName: String) {
//        companion object {}
//    }
//     fun Person.Companion.fromJSON(json: String) : Person {}
//
//    val p = Person.fromJSON(json)

    fun main(args: Array<String>) {
        KSingleton.foo()
        A.foo()
    }

    // object expressions = Java's anonymous classes

//    fun registerTestRepository(customers: Map<Int, Customer>) {
//        registerRepository(object : Repository {
//            override fun getById(id: Int): Customer? {
//                return customers[id]
//            }
//
//            override fun getAll(): List<Customer> {
//                return customers.values.toList()
//            }
//        })
//    }
    // a new instances of object expression is created for each call

    // There is no static keyword in Kotlin. There are no static members.
    // Declare "static" members
    // - at the top level
    // - inside objects
    // - inside companion object

    class C {
        companion object {
            @JvmStatic fun foo() {} // to call as a static member from Java
            fun bar() {}
        }
    }

    // nested object
    class D {
        object A
    }
}