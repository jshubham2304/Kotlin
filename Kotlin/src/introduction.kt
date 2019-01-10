@file:JvmName("Util")
fun main(args : Array<String>)
{

    //Mutable list we can modify easily
    val mutableList= mutableListOf("java")
    mutableList.add("Kotlin")
    // Can't add any values in readOnly List
        val readOnlyList = listOf("java","Kotlin")
     println("Hello")
    println(readOnlyList)
    println(listOf('a', 'b', 'c').joinToString(
            separator = "", prefix = "(", postfix = ")"))
}



fun foo(): Int {
return 0
}
