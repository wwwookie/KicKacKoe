import java.lang.Exception

// field numeration
fun printIntroField() {
    println()
    println(" 1 | 2 | 3 ")
    println("-----------")
    println(" 4 | 5 | 6 ")
    println("-----------")
    println(" 7 | 8 | 9 ")
    println()
}

// introduce players to game
fun welcomePlayer() : Int{

    println("Welcome to wwwookie's first Kotlin project: KIC-KAC-KOE, the kotlin version of TIC-TAC-TOE\n")
    println("Please choose gamemode:")
    println("Press '1' for singleplayer or '2' for multiplayer!")

    var gameMode : Int = 0

    while(gameMode != 1 || gameMode != 2){		// does while(gameMode == unassigned) work? - 0 problematic
        gameMode = readLine()!!.toInt()

        if(gameMode != 1 && gameMode != 2)
            println("Wrong input, only 1 or 2 allowed.")
        else {
            println("\nFields are numerated, remember these numbers to insert your characters later on.")
            printIntroField()
            return gameMode
        }
    }

    return gameMode
}

fun makeEmptyField(): Array<CharArray> {

    val field = Array(3) { CharArray(3) }

    for (i in 0..2)
        for (j in 0..2)
            field[i][j] = ' '

    return field
}

fun printField(field : Array<CharArray>) {

    println(" " + field[0][0] + " | " + field[0][1] + " | " + field[0][2])
    println("-----------")
    println(" " + field[1][0] + " | " + field[1][1] + " | " + field[1][2])
    println("-----------")
    println(" " + field[2][0] + " | " + field[2][1] + " | " + field[2][2])
}

// returns the wining player's character or ' ' if the game is not yet finished
fun checkGameover(field : Array<CharArray>): Char {

    // row wining cases
    for (i in 0..2)
        if (field[i][0] != ' ')
            if (field[i][0] == field[i][1]
                && field[i][1] == field[i][2])
                return field[i][0]

    // column wining cases
    for (i in 0..2)
        if (field[0][i] != ' ')
            if (field[0][i] == field[1][i]
                && field[1][i] == field[2][i])
                return field[0][i]

    // first diagonal wining case
    if (field[0][0] != ' ')
        if (field[0][0] == field[1][1])
            if (field[1][1] == field[2][2])
                return field[0][0]

    // second diagonal wining case
    if (field[0][2] != ' ')
        if (field[0][2] == field[1][1])
            if (field[1][1] == field[2][0])
                return field[0][2]

    return ' '
}

fun playSingleplayer(field : Array<CharArray>){

    var turnCounter : Int = 0

    while(checkGameover(field) == ' '){

        turnCounter++

        if (turnCounter % 2 == 0)
            println("It is your turn.")

            // do turn

        // TODO: else do bots turn


    }

    if (turnCounter % 2 == 0)
        println("O is the winner!")
    else println("X is the winner!")
}

fun playMultiplayer(field : Array<CharArray>){

    var turnCounter : Int = 0
    var fieldNumber : Int = 0
    var currentPlayer : Char = ' '

    while(checkGameover(field) == ' '){

        turnCounter++

        currentPlayer = if (turnCounter % 2 == 0)
            'O'
        else 'X'

        println("\nIt is $currentPlayer's turn")

        println("Enter the field's number (1-9) to set your character:")
        printField(field)
        fieldNumber = readLine()!!.toInt()

        // "dummy-turns" where characters would be overwritten are ignored
        // and will not be repeated
        when (fieldNumber) {
            1 -> if (field[0][0] == ' ')    field[0][0] = currentPlayer
            2 -> if (field[0][1] == ' ')    field[0][1] = currentPlayer
            3 -> if (field[0][2] == ' ')    field[0][2] = currentPlayer
            4 -> if (field[1][0] == ' ')    field[1][0] = currentPlayer
            5 -> if (field[1][1] == ' ')    field[1][1] = currentPlayer
            6 -> if (field[1][2] == ' ')    field[1][2] = currentPlayer
            7 -> if (field[2][0] == ' ')    field[2][0] = currentPlayer
            8 -> if (field[2][1] == ' ')    field[2][1] = currentPlayer
            9 -> if (field[2][2] == ' ')    field[2][2] = currentPlayer
            else -> throw Exception("Wrong input: fieldnumber must be in range 1 - 9!")
        }
    }

    println("$currentPlayer is the winner, cheers mate!")

}

fun main(args: Array<String>) {

    val gameMode : Int = welcomePlayer()		// 1 = singleplayer, 2 = multiplayer

    if(gameMode == 1)
        playSingleplayer(makeEmptyField())
    else playMultiplayer(makeEmptyField())

    // TODO: implement singlePlayer..()
    // TODO: write simple opponent-bot
}