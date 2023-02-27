package com.kotlinplayground.oop

class Oop {

    // final (used by default) cannot be overridden
    // open is opposite and it should be marked explicitly
    // abstract must be overridden (can't have implementation
    // override (mandatory) overrides a member from the superclass or interface

    // public - visible everywhere
    // internal - visible inside the module (an intelliJ IDEA module, a Maven project, or Gradle source set)
    // protected - visible in subclasses
    // private - visible in the class and in the file

    // several classes can be put into one file
    // - small and simple data classes
    // - classes connected to each other
    // - top-level declarations, functions and properties

    // package name doesn't need to correspond to the directory structure, but it still recommended
    // you to meet on the first prefix, the company name from the directory structure

    //Constructors

    // default constructor
    class A
    val a = A()

    // concise primary constructor
    class Person( val name: String, val age: Int)

    // full primary constructor syntax
    class Student(name: String) { // name is constructor parameter
        val name: String          // property declaration

        init {                    // constructor body
            this.name = name
        }
    }

    // if put val or var on a parameter creates the property
    // class Student(val name: String)

    // changing visibility of constructor
    class InternalComponent
    internal constructor(name: String)

    // secondary constructor
    class Rectangle(val height: Int, val width: Int) {

        constructor(side: Int) : this(side, side)   // this(...) calls another constructor of the same class
    }

    // Inheritance

    // the same syntax for extends and implements
    interface Base
    class BaseIml : Base

    open class ParentClass
    class ChildClass : ParentClass() // constructor call

    // calling of constructor of the parent class
    open class AnotherParent(val name: String)
    class AnotherChild(name: String) : AnotherParent(name)

    class OneMoreChild: AnotherParent {
        constructor(name: String, param: Int) : super(name)
    }

    // initialization order -> at first, parent construct is called and parents properties are initialized,
    // then child constructor is called and child properties are initialized
    open class Parent {
        init { print("parent ") }
    }

    class Child : Parent() {
        init { print("child ") }
    }

    fun main(args: Array<String>) {
        Child()                      // parent child
    }
}