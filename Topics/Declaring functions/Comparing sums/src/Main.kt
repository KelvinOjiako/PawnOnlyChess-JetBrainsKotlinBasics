// write your function here
fun isGreater(i: Int, j: Int, k: Int, l: Int): Boolean{
    return i + j > k + l
}

fun main() {
    val number1 = readLine()!!.toInt()
    val number2 = readLine()!!.toInt()
    val number3 = readLine()!!.toInt()
    val number4 = readLine()!!.toInt()

    println(isGreater(number1, number2, number3, number4))
}