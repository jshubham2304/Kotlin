package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)
fun evaluateGuess(secret: String, guess: String): Evaluation {
    //  TODO()
    var i = 0
    var blackPin = 0
    var whitePin = 0
    var tries = 0
    var track = 0

    for ( j in 0..3){
        track = 1
        if (guess[j] == secret[j]) {
            blackPin++
            println(blackPin)
            track = 0
        }
        for ( k in 0..3)
        {
            if (guess[k] == secret[j] && k != j && track != 0) {
                whitePin++
                println(whitePin)
                track = 0
            }
        }
    }
  //  if (secret.equals("EAAA"))= whitePin=-2




    return Evaluation(blackPin, whitePin)
}

