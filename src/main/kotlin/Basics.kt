fun topLevel() = 1

class Functions {
    fun member() = 2

    fun other() {
        fun local() = 3
    }

    //    fun max(a: Int, b: Int): Int {
//        return if (a > b) a else b
//    }
    fun max(a: Int, b: Int) = if (a > b) a else b

    //    fun displayMax(a: Int, b: Int): Unit {
//       println(max(a, b))
//    }
    fun displayMax(a: Int, b: Int) {
        println(max(a, b))
    }

    // Named and default arguments
    fun displaySeparator(character: Char = '*', size: Int = 10) {
        repeat(size) {
            print(character)
        }
    }

    fun main(args: Array<String>) {
        println(listOf('a', 'b', 'c').joinToString("", "(", ")"))
        println(listOf(1, 2, 3).joinToString(postfix = "."))
        displaySeparator('#', 5) // #####
        displaySeparator('#') // ##########
        displaySeparator() // **********
        displaySeparator(size = 5) // *****
        displaySeparator(size = 3, character = '5') // 555
    }

}

    class Variables {

        // val - > read-only (can't be reassigned) corresponds to final variable in Java
        val question: String = "life, the universe"
        // question = "sure?" -> compilation error

        // read-only reference, not object
        val languages = mutableListOf("Java")

        // read-only lists lacks mutating methods
        val readOnlyList = listOf("Java")

        // var -> mutable
        var number: Int = 2

        // Arrays: String[] in Java and Array<String> in Kotlin
        fun main(args: Array<String>) {
            println("$question?")

            languages.add("Kotlin")

            number = 5

            // if is an expression
            val name = if (args.isNotEmpty()) args[0] else "Kotlin"
            //String templates: $StringValue or ${functionCall(...)}
            //println("Hello, $name!")
            println("Hello, ${args.getOrNull(0)}!")

    }
}