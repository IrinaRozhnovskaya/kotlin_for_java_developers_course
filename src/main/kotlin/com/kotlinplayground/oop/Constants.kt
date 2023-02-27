package com.kotlinplayground.oop

// compile-time constant - only for primitive types and String
const val answer = 42 // the value is inlined

class Constants {

    class MyClass

    @JvmField // exposes a Kotlin property as a field in Java, No getter!
    val prop = MyClass() // public static final MyClass prop = new MyClass(); in Java

    object A {
        @JvmField
        val prop = MyClass() // static field generated
    }

    class B{
        @JvmField
        val prop = MyClass() // regular field generated
    }
}