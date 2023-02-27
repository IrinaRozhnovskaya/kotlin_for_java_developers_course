package com.kotlinplayground.types

import com.kotlinplayground.oop.Oop.Person

class TypeHierarchy {

    //                    Any
//       is the super type of all types
//            |                   |
//           Int                 User
//            |                   |
//                   Nothing
//    is the bottom type - subtype of all the other types

    // Unit instead of void - no meaningful value is returned
    fun f() {} // the same as fun f(): Unit {}
    // Unit is type that allows only one value and thus can hold no information

    // Nothing is different to Unit/void, it means "this function never returns"
    fun fail(message: String): Nothing {
        throw IllegalStateException(message)
    }
    // Nothing is a type that has no value -> the function never completes
    fun infiniteLoop(): Nothing {
        while(true) {}
    }

    // function TODO
    inline fun TODO(reason: String): Nothing =
        throw NotImplementedError("An operation is not implemented: $reason")

    // return as an expression of Nothing type
    fun greetPerson (person: Person) {
        val name = person.name ?: return
        println("Hello, $name!")
    }
}