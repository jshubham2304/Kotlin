fun main(args : Array<String>)
{
    //Mutable list we can modify easily
    val mutableList= mutableListOf("java")
    mutableList.add("Kotlin")
    // Can't add any values in readOnly List
        val readOnlyList = listOf("java","Kotlin")
     println("Hello")
    println(readOnlyList)
}