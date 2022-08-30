// write your function here
fun sum(i: Int, j: Int, k: Int): Int{
    return i + j + k;
}

fun main() {    
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    println(sum(a, b, c))
}