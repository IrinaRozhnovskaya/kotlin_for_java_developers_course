package com.kotlinplayground.nullability

class Nullability {
    // Kotlin approach: to make NPE compile-time error, not run-time error

    // Kotlin distinguishes non-nullable types (@NotNull under the hood in Java) and
    val s1: String = "always not null"

    // nullable types (@Nullable under the hood in Java) can be null or non-null value
    val s2: String? = null

    val x: Int? = 1
    val y: Int = 2

    // List of nullable elements List <Int?> vs nullable List<Int>?

    fun main(args: Array<String>) {
        s1.length // but not s2.length

        // if (s2 != null) s2.length else null -> safe access
        s2?.length

        val lengthNullable: Int? = s2?.length
        // or use Elvis operator
        val lengthNonNullable: Int = s2?.length ?: 0

        if (s2 == null) return
        s2.length // smart cast to String

        // making NPE explicit -> use not null assertion only with care
        s2!! // throws NRE if s2 is null

        // prefer parentheses
        val s1 = x ?: 0 + y // 1
        val s2 = (x ?: 0) + y // 3
        val s3 = x ?: (0 + y) // 1

        // Safe cast: as? returns null if expression cannot be cast
        // val s = if (a is String) a else null ->
        val s: String? = s1 as? String
    }
}