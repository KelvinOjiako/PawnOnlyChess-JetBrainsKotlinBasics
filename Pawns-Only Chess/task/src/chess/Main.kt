
/* Jetbrains Academy Project
  rank => rows  [denoted 1-> 8]
  file => columns [denoted a-> h]
*/
package chess
import kotlin.math.abs

const val SIZE = 8
val STARTING_POINTS = arrayOf(6, 1)

fun promptUserForInput(player: String): String{
    println("$player's turn:")  //prompts user for input
    return readln()
}
fun pawnAdvance(board: Array<Array<String>>, move: String){
    //pawns can only move once: Twice if on starting square
    //pawns can only in forward direction
    //when moving twice,

}
fun pawnCapture(board: Array<Array<String>>, move: String){
    //Diagonal Capture
    //Capturing by en-passant
    //captured pieces taken off the board
    //capturing piece lands on captured pieces square
}
fun enpassant(board: Array<Array<String>>, move: IntArray, turn: Boolean){ //edge case for pawn capture

}
fun processInput(move: String): IntArray {
    //splits string and returns a character array containing user input and a boolean showing if its valid
    //returned character array elements => beginningRank, beginningFile, endingRank, endingFile

    val currentPosition = move.slice(0 until 2)
    val endingPosition = move.slice(2 until move.length)

    val startingFile = currentPosition[0].code - 97 //gets the ascii representation of character
    val endingFile = endingPosition[0].code - 97
    val startingRank = currentPosition[1].digitToInt() - 1
    val endingRank = endingPosition[1].digitToInt() - 1
    //output => startingRank, startingFile, endingRank, endingFile, boolean(1 0r zero)
    return intArrayOf(startingRank, startingFile, endingRank, endingFile)
}
fun moveIsLegal(board: Array<Array<String>>, move: IntArray, turn: Boolean): Boolean{
    //Verifies if the intended pawn move is legal
    var legal: Boolean = false
    val (startingRank, startingFile, endingRank, endingFile) = move
    val squaresMoved = endingRank - startingRank
    //Ensures Pawns can't move backwards
    val forwardMove= squaresMoved > 0 && turn || squaresMoved < 0 && !turn

    val squareIsAvailable = board[endingRank][endingFile] == " " //ensures there's no pawn in the way
    val sign = if (turn) "W" else "B"
    val sameFile = startingFile == endingFile

    //PlayerPieceChose checks if player is moving their own piece
    val playerPieceChosen = board[endingRank][endingFile] == sign
    val output = "No ${if (turn) "white" else "black"} pawn at ${(startingFile + 97).toChar()}${startingRank+1}"

    val allowedAdvance = abs(squaresMoved) in 1..2 //Ensures all pawn moves outside range: 2 >= x >= 1 are invalid
    //Pawns can only move forward in one direction

    if (!playerPieceChosen){//Ensures player picks their piece and not opponents piece
        println(output)
    }
    else if (forwardMove && allowedAdvance && squareIsAvailable && sameFile){
        //Validates pawn movement
        if (squaresMoved == 1){
            legal =  true
        } else if (squaresMoved == 2 && startingRank in STARTING_POINTS){
            legal = true
        } else println("Invalid Input")
    }
    else println("Invalid Input")

    return legal
}

fun captureIsLegal(board: Array<Array<String>>, move: IntArray, turn: Boolean): Boolean{
    var legal= false

    return legal
}

fun movePieceForward(board: Array<Array<String>>, move: IntArray, turn: Boolean){
    val (startingRank, startingFile, endingRank, endingFile) = move
    val squaresMoved = abs(endingRank - startingRank)
    val doubleMoveMarker = "."
    val sign = if (turn) "W" else "B"
    val iterator = if (turn) +1 else -1
    board[startingRank][startingFile] = " "
    board[endingRank][endingFile] = sign

    if (squaresMoved == 2){
        board[endingRank - iterator][endingFile] = doubleMoveMarker
    }
}
fun changeState(board: Array<Array<String>>, move: String, turn: Boolean): Boolean?{
    var legal: Boolean? = false

    val currentPosition = move.slice(0 until 2)
    val intendedPosition = move.slice(2 until move.length)

    //******Implementation to prevent pawns from moving backwards TODO()*************
    val correctDirection = false
    val squares = intendedPosition[1].digitToInt() - currentPosition[1].digitToInt()

    val squaresMoved = abs ( squares )

    val fiile = intendedPosition[0].code - 97 //gets the ascii representation of character
    val intendedRank = intendedPosition[1].digitToInt() - 1
    val startingRank = currentPosition[1].digitToInt() - 1
    var availableSquare = board[intendedRank][fiile] == " "
    val sign = if (turn) "W" else "B"
    val piecePresent = board[startingRank][fiile] == sign
    val output = "No ${if (turn) "white" else "black"} pawn at $currentPosition"
    //Error Statements for invalid input and no pawn on available square TODO() Error Implementation
    if(!piecePresent) {
        println(output)
        return legal
    } else if (!(squares > 0 && turn || squares < 0 && !turn) || squares == 0){
        println("Invalid Input")
        return legal
    }


    if(currentPosition[0] == intendedPosition[0] && squaresMoved >= 1 && squaresMoved <= 2 && availableSquare){
        //println("inside firs if. The starting rank is $startingRank")
        if(startingRank in STARTING_POINTS || squaresMoved == 1){
            //if it's still on its starting square then it's allowed to move 2 squares forward
            board[startingRank][fiile] = " "
            //println("legalMoveSet")
            board[intendedRank][fiile] = sign
            displayBoard(board)
            legal = true
        }else println("Invalid Input")
    } else println("Invalid Input")

    return legal
}


fun validateUserInput(input: String): Boolean? {
    //1) Validates userInput 2) ensures only the right characters are entered

    if (input == "exit") { //game ends when user inputs exit
        println("Bye!")
        return null
    }
    val regex = "[a-hA-H][1-8][a-hA-H][1-8]".toRegex()
    return regex.matches(input)
}

fun chessManager(board: Array< Array<String> >){
    println("First Player's name:")
    val p1 = readln()
    println("Second Player's name:")
    val p2 = readln()

    var whiteTurn = true //white starts first => true implies whites turn
    var validInput: Boolean? = false //null value means user wants to exit
    var currentPlayer: String
    var userInput: String
    displayBoard(board)

    while(validInput != null){
        currentPlayer = if (whiteTurn) p1 else p2
        println("$currentPlayer's turn:")  //prompts user for input
        userInput = readln()  //reads in console input
        validInput = validateUserInput(userInput) //validates input
        
        if (validInput == true) {
            whiteTurn = !whiteTurn
            val container = processInput(userInput) //splits user input into an array
            val (startingRank, startingFile, endingRank, endingFile) = container


        } else println("Invalid Input")
    }

}
fun defaultSetup(): Array < Array<String> > {
    val chessBoard =  Array(SIZE) { Array(SIZE) { " " }  }
    var pawnColor: String
    for (i in STARTING_POINTS){
        pawnColor = if (i == 1) "W" else "B"
        for(j in 0 until SIZE){
            chessBoard[i][j] = pawnColor
        }
    }
    return chessBoard
}
fun displayBoard(board: Array < Array<String> >){
    for(i in SIZE-1 downTo 0){
        println("  +---+---+---+---+---+---+---+---+")
        print("${i+1} |")
        for(j in 0 until SIZE){
            print(" ${board[i][j]} |")
        }
        println()
    }
    println("  +---+---+---+---+---+---+---+---+")
    println("    a   b   c   d   e   f   g   h\n")
}
fun main() {
    println("Pawns-Only Chess")
    val chessBoard = defaultSetup()
    chessManager(chessBoard)
}