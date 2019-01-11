fun isValidIdentifier(s: String): Boolean {
//

    fun ischarcater(ch : Char)= ch in '0'..'9' || ch in 'a'..'z' || ch == '_' || ch in 'A'..'Z'
if(s.isEmpty() || s[0] in '0'..'9') return false
    for (ch in s){
    if(!ischarcater(ch)) return false
}
    return true
}
fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    val ab = try {
         println(Integer.parseInt("1"))

    }
    catch (e:NumberFormatException){
        println(e)
    }
}