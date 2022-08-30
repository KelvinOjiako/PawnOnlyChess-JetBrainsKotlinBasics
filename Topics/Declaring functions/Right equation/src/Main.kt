// write your code here
fun isRightEquation(i: Int, j: Int, k: Int): Boolean {
    return i * j == k
}
/* Do not change code below */
fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    println(isRightEquation(a, b, c))
}