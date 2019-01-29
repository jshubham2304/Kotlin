package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var positions = 0
    val a = mutableListOf<Int>()
    var z = 0
    var letter = 0
    for (i in 0 until secret.length) {
        if (secret[i] == guess[i]) {
            a.add(i)
            z++
            positions++
        } else if (secret[i] != guess[i]) {
            for (j in 0 until secret.length) {
                if (secret[i] == guess[j]) {
                    var flag = 0
                    for (k in 0 until z) {
                        if (a[k] == j) {
                            flag = 1
                        }
                    }
                    if (flag == 0) {
                        a.add(j)
                        z++
                        letter++
                        break
                    }
                }
            }
        }
    }
    return Evaluation(positions, letter)

}
