
fun main(args : Array<String>) {

println(" get climate "+getDesc(Color.BLUE))
    val map = mapOf(1 to "one",2 to "two",3 to "three")
    for((key,value) in map)
    {
        println("key :$key , values :$value")
    }
    for (ch in "abc") {
        print(ch + 1)
    }
}
enum class Color{
    BLUE,ORANGE,RED
}
fun getDesc(color : Color):String{
    when(color){
        Color.BLUE->return "Cold"
        Color.RED->return "hot"
        Color.ORANGE->return "mild"
    }
}