package com.kotlinplayground.properties

class Properties {

    // defined field with the corresponding getter and setter in Java is considering as a property in Kotlin
    class KotlinClass {
        var foo = 0 // another syntax,
    // but property = field + accessor(s)

    // read-only property
    // val = field + getter

    // mutable property
    // var = field + getter + setter

    // kotlinClass.foo        (get)
    // kotlinClass.foo = ""   (set)
    }

    // field might be omitted
    // property = accessor(s)
    class Rectangle(val height: Int, val width: Int) {

        val isSquare: Boolean
            get() {
                return height == width
            }
        }

    // extension properties
    val String.lastIndex: Int
        get() = this.length - 1

    val String.indexes: IntRange
        get() = 0..lastIndex

    // mutable extension properties
    var StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value: Char) {
            this.setCharAt(length - 1, value)
        }

    // Implement the property 'foo' so that it produced a different value on each access
    var counter: Int = 0
    val foo: Int
        get() = counter++

    // lazy property is a property which values are computed only on the first access
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }

    // lateinit property

//    class KotlinActivity: Activity() {
//        lateinit var MyData: MyData // can't be val, type of property (MyData) can't be nullable and primitive type
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            myData = intent.getParcelableExtra("MY_DATA")
//        }
//    }

    // if the property is not initialized -> message that the myData property wasn't initialized

    class A {
        private lateinit var prop: String

        fun setUp() {
            prop = "value"
        }

        fun display() {
            println(prop)
        }
    }

    fun main(args: Array<String>) {
        val rectangle = Rectangle(2,3)
        println(rectangle.isSquare)      // false

        "abc".lastIndex // 2
        "abc".indexes // 0..2

        val sb = StringBuilder("Kotlin?")
        sb.lastChar = '!'
        println(sb)   // Kotlin!

        println(foo) // 0
        println(foo) // 1
        println(foo) // 2

        println(lazyValue)
        println(lazyValue) // computed!
                           // Hello
                           // Hello
        val a = A()
        // a.display() // kotlin.UninitializedPropertyAccessException: lateinit property prop has not been initialized
        a.setUp()
        a.display() // value
    }

    // property in an interface
    interface User {
        val nickname: String
    }

    class SubscribingUser(val email: String) : User {
        override val nickname: String
            get() = email.substringBefore('@')
    }

    // all the properties in interfaces are open and can't be used in smart casts
}