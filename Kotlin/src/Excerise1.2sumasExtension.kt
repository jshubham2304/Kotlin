import java.util.*

import kotlin.random.Random
val ALPHABET = 'A'..'F'
val CODE_LENGTH = 4
val count =5
var gamstring = listOf("ABCD","DCBA","ABCD","ABCD","DAEF","AABC","AABC")
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

//fun evaluateGuess(secret: String, guess: String): Evaluation {
//    //  TODO()
//    // not getting right answer
//    var i = 0
//    var blackPin = 0
//    var whitePin = 0
//    var tries = 0
//    var track = 0
//
//        for ( j in 0..3){
//            track = 1
//            if (guess[j] == secret[j]) {
//                blackPin++
//                println(blackPin)
//                track = 0
//            }
//            if(j<3){
//            if(secret[j]==secret[j+1] )
//            {
//                tries++
//            }
//            }
//            for ( k in 0..3)
//            {
//                if (guess[k] == secret[j] && track != 0) {
//                    whitePin++
//                    println(whitePin)
//                    track = 0
//                }
//            }
//
//        }
//
//
//
//    return Evaluation(blackPin, whitePin)
//}
 fun evaluateGuess(secret: String, guess: String): Evaluation {
//    val positions = getGuessedInRightPositions(secret, guess)
    var positions = 0
    for(i in 0 until secret.length) { //How many letter guessed
        if(secret[i] == guess[i]) { //Guessed right and in the right position
            positions ++
        }
    }

//    val letters = getGuessedInWrongPositions(secret, guess)
    var letters = 0
    var newSecret = ""
    var newGuess = ""

    for(i in 0 until secret.length) {
        if(secret[i] != guess[i]) {
            newSecret += secret[i]
            newGuess += guess[i]
        }
    }

    val evaluatedChars = mutableListOf<Char>()
    if(!newSecret.isEmpty()) {
        for (i in 0 until guess.length) {
            val letter = guess[i]
            if (!evaluatedChars.contains(letter)) {
                val howManyInSecret = countHowMany(newSecret, letter)
                val howManyInGuess = countHowMany(newGuess, letter)
                letters += if (howManyInSecret == howManyInGuess || howManyInSecret > howManyInGuess) howManyInGuess
                else howManyInSecret

                evaluatedChars.add(letter)
            }
        }
    }

    return Evaluation(positions, letters)
}

fun countHowMany(letters: String, letter: Char): Int {
    var howMany = 0
    for (i in 0 until letters.length) {
        if (letters[i] == letter) {
            howMany++
        }
    }
    return howMany
}