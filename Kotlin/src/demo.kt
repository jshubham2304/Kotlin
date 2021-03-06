import java.util.*

fun main(args: Array<String>) {
//    var fortune: String
//    for (i in 1..10) {
//        fortune = getFortune()
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break
//    }
    var rollDice0 = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    var rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    gameplay(rollDice2(0))
}

fun getFortune() : String {
    val fortunes = listOf( "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends, because they are your greatest fortune.")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1

    return fortunes[birthday.rem(fortunes.size)]

}

fun gameplay(roll : Int) {
   print("$roll")
    }
