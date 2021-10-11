fun welcomePlayer() : Int{

    println("Welcome to wwwookie's first Kotlin project: KIC-KAC-KOE, the kotlin version of TIC-TAC-TOE\n")
    println("Please choose gamemode:\n")
    println("\tpress '1' for singleplayer or '2' for multiplayer!")

    var gameMode : Int = 0

    while(gameMode != 1 || gameMode != 2){		// does while(gameMode == unassigned) work? - 0 problematic
        if(gameMode == 0)
            println("Wrong input, only 1 or 2 allowed.")

        gameMode = readLine()!!.toInt()
    }

    return gameMode
}

fun makeEmptyField(): Array<CharArray> {

    val field = Array(3) { CharArray(3) }

    for(i in 0..2)
        for(j in 0..2)
            field[i][j] = ' '

    return field
}

fun checkGameover(field : Array<CharArray>): Boolean {
    return true
}

fun playSingleplayer(field : Array<CharArray>){


    while(!checkGameover(field)){
        // TODO
    }
}

fun playMultiplayer(field : Array<CharArray>){

    while(!checkGameover(field)){
        // TODO
    }

}

fun main(args: Array<String>) {

    val gameMode : Int = welcomePlayer()		// 1 = singleplayer, 2 = multiplayer

    if(gameMode == 1)
        playSingleplayer(makeEmptyField())
    else playMultiplayer(makeEmptyField())

    // TODO: implement play..()
    // TODO: write simple opponent-bot
}