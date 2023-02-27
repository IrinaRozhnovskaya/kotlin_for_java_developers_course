package com.kotlinplayground.types

class CollectionTypes {
    val set = setOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    // kotlin.List and kotlin.MutableList -> java.util.ArrayList

    // kotlin.MutableList extends kotlin.List

    // read-only interface just lacks mutating methods is not immutable -> can be changed by another reference
    val mutableList = mutableListOf(1, 2, 3)
    val arrayList: List<Int> = mutableList

    fun main(args: Array<String>) {
        set.javaClass     // java.util.HashSet
        list.javaClass    // java.util.ArrayList
        map.javaClass     // java.util.HashMap

        mutableList.add(4)
        println(arrayList) // [1, 2, 3, 4]
    }
}