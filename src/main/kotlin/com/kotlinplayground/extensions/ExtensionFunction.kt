package com.kotlinplayground.extensions

class ExtensionFunction {
    // String is the receiver, this can be omitted
    //fun String.lastChar() = this.get(this.length - 1)
    fun String.lastChar() = get(length - 1)
    // should be imported to use in whole project
    val c: Char = "abc".lastChar()

    // Calling from Java code
    // import static ExtensionFunctionKt.lastChar;
    // char c = lastChar("abc");

    // Extensions are the static Java functions under the hood -> No override to extension functions in Kotlin
    // When the compiler chooses the right function to be called, it only uses the type of the receiver expression,
    // not the actual stored value.
    open class Parent
    class Child: Parent()

    fun Parent.foo() = "parent"
    fun Child.foo() = "child"

    fun main(args: Array<String>) {
        val parent: Parent = Child()
        println(parent.foo()) // parent
    }

    // Extensions don't hide members
    class A {
        fun foo() = 1
    }

    fun A.foo() = 2 // Warning: Extension is shadowed by a member and A.foo() -> 1

    // Extensions can overload members
    class B {
        fun foo() = "member"
    }

    fun A.foo(i: Int) = "extension($i)" // A.foo(2) -> extension(2)
}
