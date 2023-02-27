package com.kotlinplayground.functionalprogramming

class MemberReferences {

   class Person(val name: String, val age: Int) {
       fun isOlder(ageLimit: Int) = age > ageLimit

       fun getAgePredicate() = this::isOlder // this can be omitted ::isOlder
   }

    val people = listOf<Person>()

    fun isEven(i: Int): Boolean = i % 2 == 0
    // function reference (non-bound)
    val predicate = ::isEven // the same like lambda val predicate = { i: Int -> isEven(i) }

    // passing function reference as an argument
    val list = listOf(1, 2, 3, 4)

    // non-bound reference
    val agePredicate = Person::isOlder

    val alise = Person("Alise", 29)

    // bound reference
    val anotherAgePredicate: (Int) -> Boolean = alise::isOlder

    fun main(args: Array<String>) {
     // Kotlin has member references like Java
     people.maxBy(Person::age)

     list.any(::isEven) // true
     list.filter(::isEven) // [2, 4]

     agePredicate(alise, 21) // true
     anotherAgePredicate(21) // true

     // bound reference
     alise.getAgePredicate()
    }
}