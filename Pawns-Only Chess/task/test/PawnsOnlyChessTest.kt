import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class PawnsOnlyChessTest : StageTest<Any>() {
// Tests added 11-Nov-21, Start
    @DynamicTest
    fun directCapture1(): CheckResult {
        for (ch in 'a'..'g') {
            val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
            val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

            val main = TestedProgram()
            var outputString = main.start().trim()

            var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
            if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
            position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

            outputString = main.execute("John").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

            outputString = main.execute("Amelia").trim()
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")


            outputString = main.execute("${ch}2${ch}4").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch + 1}7${ch + 1}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 8))
            pawnsBlack.add(Pair(4, ch - 'h' + 8))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("${ch}4${ch + 1}5").trim()
            pawnsWhite.remove(Pair(3, ch - 'h' + 7))
            pawnsBlack.remove(Pair(4, ch - 'h' + 8))
            pawnsWhite.add(Pair(4, ch - 'h' + 8))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after capturing.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("exit").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "bye")
            if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

            if (!main.isFinished) return CheckResult(false, "The application didn't exit.")
        }

        return CheckResult.correct()
    }

    @DynamicTest
    fun directCapture2(): CheckResult {
        for (ch in 'b'..'h') {
            val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
            val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

            val main = TestedProgram()
            var outputString = main.start().trim()

            var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
            if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
            position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

            outputString = main.execute("John").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

            outputString = main.execute("Amelia").trim()
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")


            outputString = main.execute("${ch}2${ch}4").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch - 1}7${ch - 1}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 6))
            pawnsBlack.add(Pair(4, ch - 'h' + 6))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("${ch}4${ch - 1}5").trim()
            pawnsWhite.remove(Pair(3, ch - 'h' + 7))
            pawnsBlack.remove(Pair(4, ch - 'h' + 6))
            pawnsWhite.add(Pair(4, ch - 'h' + 6))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout capturing.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("exit").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "bye")
            if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

            if (!main.isFinished) return CheckResult(false, "The application didn't exit.")
        }

        return CheckResult.correct()
    }

    @DynamicTest
    fun directCapture3(): CheckResult {
        for (ch in 'a'..'g') {
            val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
            val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

            val main = TestedProgram()
            var outputString = main.start().trim()

            var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
            if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
            position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

            outputString = main.execute("John").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

            outputString = main.execute("Amelia").trim()
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")


            outputString = main.execute("${ch}2${ch}3").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(2, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch + 1}7${ch + 1}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 8))
            pawnsBlack.add(Pair(4, ch - 'h' + 8))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("${ch}3${ch}4").trim()
            pawnsWhite.remove(Pair(2, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after a forward move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch + 1}5${ch}4").trim()
            pawnsBlack.remove(Pair(4, ch - 'h' + 8))
            pawnsWhite.remove(Pair(3, ch - 'h' + 7))
            pawnsBlack.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after capturing.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("exit").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "bye")
            if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

            if (!main.isFinished) return CheckResult(false, "The application didn't exit.")
        }

        return CheckResult.correct()
    }

    @DynamicTest
    fun directCapture4(): CheckResult {
        for (ch in 'b'..'h') {
            val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
            val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

            val main = TestedProgram()
            var outputString = main.start().trim()

            var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
            if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
            position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

            outputString = main.execute("John").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
            if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

            outputString = main.execute("Amelia").trim()
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")


            outputString = main.execute("${ch}2${ch}3").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(2, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch - 1}7${ch - 1}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 6))
            pawnsBlack.add(Pair(4, ch - 'h' + 6))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("${ch}3${ch}4").trim()
            pawnsWhite.remove(Pair(2, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after a forward move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch - 1}5${ch}4").trim()
            pawnsBlack.remove(Pair(4, ch - 'h' + 6))
            pawnsWhite.remove(Pair(3, ch - 'h' + 7))
            pawnsBlack.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after capturing.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

            outputString = main.execute("exit").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "bye")
            if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

            if (!main.isFinished) return CheckResult(false, "The application didn't exit.")
        }

        return CheckResult.correct()
    }
// Tests added 11-Nov-21, End
    @DynamicTest
    fun testAdd4(): CheckResult {
        for (ch in listOf('a', 'c', 'e')) {
            val chList = ('a'..'h').filter {it - ch > 1 }
            for (ch2 in chList) {

                val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
                val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

                val main = TestedProgram()
                var outputString = main.start().trim()

                var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
                if (position == -1) return CheckResult(false, "Program title is expected.")
                position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
                if (position == -1) return CheckResult(false, "Player 1 name prompt is expected.")

                outputString = main.execute("John").trim()
                position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
                if (position == -1) return CheckResult(false, "Player 2 name prompt is expected.")

                outputString = main.execute("Amelia").trim()
                position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
                if (position == -1) return CheckResult(false, "Wrong initial chessboard printout.")
                position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
                if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

                outputString = main.execute("${ch}2${ch}4").trim()
                pawnsWhite.remove(Pair(1, ch - 'h' + 7))
                pawnsWhite.add(Pair(3, ch - 'h' + 7))
                position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
                if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
                position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
                if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

                outputString = main.execute("a7a6").trim()
                pawnsBlack.remove(Pair(6, 0))
                pawnsBlack.add(Pair(5, 0))
                position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
                if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
                position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
                if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

                outputString = main.execute("${ch}4${ch}5").trim()
                pawnsWhite.remove(Pair(3, ch - 'h' + 7))
                pawnsWhite.add(Pair(4, ch - 'h' + 7))
                position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
                if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
                position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
                if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

                outputString = main.execute("${ch2}7${ch2}5").trim()
                pawnsBlack.remove(Pair(6, ch2 - 'h' + 7))
                pawnsBlack.add(Pair(4, ch2 - 'h' + 7))
                position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
                if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
                position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
                if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

                outputString = main.execute("${ch}5${ch2}6").trim()
                position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
                if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

                outputString = main.execute("${ch}5${ch + 1}6").trim()
                position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
                if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

                outputString = main.execute("exit").trim()
                position = checkOutput(outputString.toLowerCase(), 0, "bye")
                if (position == -1) return CheckResult(false, "Exit message is expected.")
            }
        }

        return CheckResult.correct()
    }

    @DynamicTest
    fun testAdd3(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        for (ch in 'a'..'h') {
            outputString = main.execute("${ch}2${ch}4").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch}7${ch}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 7))
            pawnsBlack.add(Pair(4, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")
        }

        for (ch in listOf('a', 'e', 'h')) {
            val chList = ('a'..'h').filter { kotlin.math.abs(it - ch) > 1 }
            for (ch2 in chList) {
                outputString = main.execute("${ch}4${ch2}5").trim()
                position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
                if (position == -1) return CheckResult(false, "Incorrect output after an invalid command.")
            }
        }

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun testAdd2(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) { index -> Pair(1, index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) { index -> Pair(6, index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("a2a4").trim()
        pawnsWhite.remove(Pair(1, 0))
        pawnsWhite.add(Pair(3, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("a7a5").trim()
        pawnsBlack.remove(Pair(6, 0))
        pawnsBlack.add(Pair(4, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")

        for (ch in 'b'..'h') {
            outputString = main.execute("${ch - 1}4${ch - 1}5").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
            if (position == -1) return CheckResult(false, "Incorrect output after an invalid command.")

            outputString = main.execute("${ch}2${ch}4").trim()
            pawnsWhite.remove(Pair(1, ch - 'h' + 7))
            pawnsWhite.add(Pair(3, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
            if (position == -1) return CheckResult(false, "Player 2 prompt to play is expected.")

            outputString = main.execute("${ch - 1}5${ch - 1}4").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
            if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

            outputString = main.execute("${ch}7${ch}5").trim()
            pawnsBlack.remove(Pair(6, ch - 'h' + 7))
            pawnsBlack.add(Pair(4, ch - 'h' + 7))
            position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
            if (position == -1) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
            position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
            if (position == -1) return CheckResult(false, "Player 1 prompt to play is expected.")
        }
        outputString = main.execute("h4h5").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if (position == -1) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }


    @DynamicTest
    fun testAdd1(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2e2").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("d2d1").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("c2c5").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("a2a6").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("g2g7").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("a2a8").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("b3b3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no white pawn at b3", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no white pawn.")

        outputString = main.execute("c4c4").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no white pawn at c4", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no white pawn.")

        outputString = main.execute("f2f1").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        for (ch in 'a'..'g') {
            outputString = main.execute("${ch}2${ch+1}3").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
            if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")
        }

        outputString = main.execute("h2g3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e2e3").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(2, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        for (ch in 'a'..'g') {
            outputString = main.execute("${ch}7${ch+1}6").trim()
            position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
            if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")
        }

        outputString = main.execute("h7g6").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e7e7").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("b7b8").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e7e4").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("h7h3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("g7g2").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("a7a1").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("a6a6").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no black pawn at a6", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no black pawn.")

        outputString = main.execute("f5f5").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no black pawn at f5", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no black pawn.")

        outputString = main.execute("d7d8").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e7e6").trim()
        pawnsBlack.remove(Pair(6, 4))
        pawnsBlack.add(Pair(5, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e3e2").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e3e1").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e3e3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("h2h3").trim()
        pawnsWhite.remove(Pair(1, 7))
        pawnsWhite.add(Pair(2, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("e6e6").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e6e7").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e6e8").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("h7h5").trim()
        pawnsBlack.remove(Pair(6, 7))
        pawnsBlack.add(Pair(4, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("h3h4").trim()
        pawnsWhite.remove(Pair(2, 7))
        pawnsWhite.add(Pair(3, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("h5h4").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun test1(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("a2a3").trim()
        pawnsWhite.remove(Pair(1, 0))
        pawnsWhite.add(Pair(2, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("a7a6").trim()
        pawnsBlack.remove(Pair(6, 0))
        pawnsBlack.add(Pair(5, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2e4").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(3, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("e7e5").trim()
        pawnsBlack.remove(Pair(6, 4))
        pawnsBlack.add(Pair(4, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun test2(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }
        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2d3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e2f3").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("e3e4").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no white pawn at e3", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no white pawn.")

        outputString = main.execute("d7d8").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no white pawn at d7", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no white pawn.")

        outputString = main.execute("e2e3").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(2, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("b6b5").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no black pawn at b6", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no black pawn.")

        outputString = main.execute("a2a1").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "no black pawn at a2", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after trying to make a move from a square with no black pawn.")

        outputString = main.execute("e7e6").trim()
        pawnsBlack.remove(Pair(6, 4))
        pawnsBlack.add(Pair(5, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e3e5").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")

        outputString = main.execute("h2h3").trim()
        pawnsWhite.remove(Pair(1, 7))
        pawnsWhite.add(Pair(2, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("e6e4").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid command.")


        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun test3(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2e4").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(3, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("d7d5").trim()
        pawnsBlack.remove(Pair(6, 3))
        pawnsBlack.add(Pair(4, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e4d5").trim()
        pawnsBlack.remove(Pair(4, 3))
        pawnsWhite.remove(Pair(3, 4))
        pawnsWhite.add(Pair(4, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after capture move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("c7c6").trim()
        pawnsBlack.remove(Pair(6, 2))
        pawnsBlack.add(Pair(5, 2))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("a2a4").trim()
        pawnsWhite.remove(Pair(1, 0))
        pawnsWhite.add(Pair(3, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("c6d5").trim()
        pawnsWhite.remove(Pair(4, 3))
        pawnsBlack.remove(Pair(5, 2))
        pawnsBlack.add(Pair(4, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after capture movev.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun test4(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2e4").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(3, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("a7a6").trim()
        pawnsBlack.remove(Pair(6, 0))
        pawnsBlack.add(Pair(5, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e4e5").trim()
        pawnsWhite.remove(Pair(3, 4))
        pawnsWhite.add(Pair(4, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("d7d5").trim()
        pawnsBlack.remove(Pair(6, 3))
        pawnsBlack.add(Pair(4, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e5d6").trim()
        pawnsBlack.remove(Pair(4, 3))
        pawnsWhite.remove(Pair(4, 4))
        pawnsWhite.add(Pair(5, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after en passant capture.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

    @DynamicTest
    fun test5(): CheckResult {
        val pawnsWhite = MutableList<Pair<Int, Int>>(8) {index -> Pair(1,index) }
        val pawnsBlack = MutableList<Pair<Int, Int>>(8) {index -> Pair(6,index) }

        val main = TestedProgram()
        var outputString = main.start().trim()

        var position = checkOutput(outputString.toLowerCase(), 0, "pawns-only chess")
        if ( position  == -1 ) return CheckResult(false, "Program title is expected.")
        position = checkOutput(outputString.toLowerCase(), position, "first player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 name prompt is expected.")

        outputString = main.execute("John").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "second player's name:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 name prompt is expected.")

        outputString = main.execute("Amelia").trim()
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong initial chessboard printout.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e2e4").trim()
        pawnsWhite.remove(Pair(1, 4))
        pawnsWhite.add(Pair(3, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("a7a6").trim()
        pawnsBlack.remove(Pair(6, 0))
        pawnsBlack.add(Pair(5, 0))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e4e5").trim()
        pawnsWhite.remove(Pair(3, 4))
        pawnsWhite.add(Pair(4, 4))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("d7d5").trim()
        pawnsBlack.remove(Pair(6, 3))
        pawnsBlack.add(Pair(4, 3))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 2 squares move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("h2h3").trim()
        pawnsWhite.remove(Pair(1, 7))
        pawnsWhite.add(Pair(2, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "amelia's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 2 prompt to play is expected.")

        outputString = main.execute("h7h6").trim()
        pawnsBlack.remove(Pair(6, 7))
        pawnsBlack.add(Pair(5, 7))
        position = checkChessboard(outputString, 0, pawnsWhite, pawnsBlack)
        if ( position  == -1 ) return CheckResult(false, "Wrong chessboard printout after 1 square move.")
        position = checkOutput(outputString.toLowerCase(), position, "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Player 1 prompt to play is expected.")

        outputString = main.execute("e5d6").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "invalid input", "john's turn:")
        if ( position  == -1 ) return CheckResult(false, "Incorrect output after an invalid en passant capture.")

        outputString = main.execute("exit").trim()
        position = checkOutput(outputString.toLowerCase(), 0, "bye")
        if ( position  == -1 ) return CheckResult(false, "Exit message is expected.")

        return CheckResult.correct()
    }

}

fun checkChessboard(outputString: String, searchPos: Int, pawnsWhite: List<Pair<Int, Int>>, pawnsBlack: List<Pair<Int, Int>>): Int {
    fun createChessboardStringList(pawnsWhite: List<Pair<Int, Int>>, pawnsBlack: List<Pair<Int, Int>>): List<String> {
        var chessboard = "  +---+---+---+---+---+---+---+---+\n"
        for (i in 7 downTo 0) {
            chessboard += "${i + 1} |"
            for (j in 0..7) {
                val square = when {
                    pawnsWhite.contains(Pair(i, j)) -> 'W'
                    pawnsBlack.contains(Pair(i, j)) -> 'B'
                    else -> ' '
                }
                chessboard += " $square |"
            }
            chessboard += "\n  +---+---+---+---+---+---+---+---+\n"
        }
        chessboard += "    a   b   c   d   e   f   g   h\n"
        return chessboard.trim().split("\n").map { it.trim() }
    }
    val chessboardStringList = createChessboardStringList(pawnsWhite, pawnsBlack)
    return checkOutput(outputString, searchPos, * chessboardStringList.toTypedArray())
}

fun checkOutput(outputString: String, searchPos: Int, vararg checkStr: String): Int {
    var searchPosition = searchPos
    for (str in checkStr) {
        val findPosition = outputString.indexOf(str, searchPosition)
        if (findPosition == -1) return -1
        if ( outputString.substring(searchPosition until findPosition).isNotBlank() ) return -1
        searchPosition = findPosition + str.length
    }
    return searchPosition
}


