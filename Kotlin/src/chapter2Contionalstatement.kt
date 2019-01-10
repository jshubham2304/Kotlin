
fun main(args : Array<String>) {

println(getDesc(Color.BLUE))
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