import java.util.*

import kotlin.random.Random
val ALPHABET = 'A'..'F'
val CODE_LENGTH = 4
val count =5
var gamstring = listOf("DCFC")
data class Evaluation(val blackPin: Int, val whitePin: Int)
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) result += i
    return result
}

fun main(args: Array<String>) {
    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
    playBullsAndCows()
}
fun playBullsAndCows()
        //secret: String = generateSecr)
        {
    var i=0
    var evaluation: Evaluation

    do {
        print("Your guess: ")
        var guess = readLine()!!
        while (hasErrorsInInput(guess)) {
            println("Incorrect input: $guess. " +
                    "It should consist of $CODE_LENGTH digits. " +
                    "Try again.")
            guess = readLine()!!
        }
        println(gamstring[i])
        evaluation = evaluateGuess(gamstring[i], guess)

            println("Positions: ${evaluation.blackPin}; letters: ${evaluation.whitePin}.")

    i++
    } while (i!=7)
}

fun Evaluation.isComplete(): Boolean = blackPin == CODE_LENGTH

fun hasErrorsInInput(guess: String): Boolean {
    val possibleLetters = ALPHABET.toSet()
    return guess.length != CODE_LENGTH || guess.any { it !in possibleLetters }
}

fun generateSecret(differentLetters: Boolean = false): String {
    val chars = ALPHABET.toMutableList()
        for (i in 1..4) {
            return gamstring[i]
        }
    return null.toString()
}


fun evaluateGuess(secret: String, guess: String): Evaluation {
    //    val positions = getGuessedInRightPositions(secret, guess)
    var positions = 0
    var hascorrespondingArray = mutableListOf<Boolean>(false,false,false,false)
    var haschecked = mutableListOf<Boolean>(false,false,false,false)
    var letter = 0
    for (i in 0 until guess.length) {

        if (secret[i] === guess[i]) {
            positions++
            hascorrespondingArray[i] = true
            haschecked[i] = true
        }
    }
    for (j in 0 until guess.length) {
        for (k in 0 until secret.length) {
            if (guess[j] === secret[k] && !hascorrespondingArray[k] && !haschecked[j]) {
                letter++
                haschecked[j] = true

                hascorrespondingArray[k] = true
            }
        }
    }

    return Evaluation(positions, letter)

}