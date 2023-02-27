package com.kotlinplayground.functionalprogramming

import  com.kotlinplayground.functionalprogramming.CollectionOperations.Gender.*

class CollectionOperations {
    data class Hero (
        val name: String,
        val age: Int,
        val gender: Gender?
        )
    enum class Gender { MALE, FEMALE }

    private val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE))

    fun main(args: Array<String>) {
        heroes.last().name // Sir Stephen
        heroes.firstOrNull { it.age == 30 }?.name // null
        heroes.map { it.age }.distinct().size // 5
        heroes.filter { it.age < 30 }.size // 3
        val (youngest, oldest) = heroes.partition { it.age < 30 }
        oldest.size // 3
        heroes.maxBy { it.age }?.name // The Captain
        heroes.all { it.age < 50 } // false
        heroes.any { it.gender == FEMALE } // true

        val mapByAge: Map<Int, List<Hero>> =
            heroes.groupBy { it.age }   // mapOf(60 -> listOf(Hero("The Captain", 60, MALE)),
                                        //      (42 -> listOf(Hero("Frenchy", 42, MALE)),
                                        //      (9 -> listOf(Hero("The Kid", 9, null)),
                                        //      (29 -> listOf(Hero("Lady Lauren", 29, FEMALE),
                                        //                    Hero("First Mate", 29, MALE)),
                                        //      (37 -> listOf(Hero("Sir Stephen", 37, MALE)))
        val (age, group) = mapByAge.maxBy { (_, group) ->
            group.size
        }!!
        println(age) // 29

        val mapByName: Map<String, Hero> =
            heroes.associateBy { it.name }
        mapByName["Frenchy"]?.age // 42

        val unknownHero = Hero("Unknown", 0, null)
        mapByName.getOrElse("unknown") { unknownHero }.age // 0
    }
}
