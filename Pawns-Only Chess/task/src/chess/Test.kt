package chess
import java.util.Scanner

fun main(){
    fun main() {
        // write your code here
        val sc = Scanner(System.`in`)
        val highestNumber = 0
        val highestCount = 0
        var totalCount = 0
        while (sc.hasNext() ){
            var value  = sc.nextLine().toCharArray().filter{ it.isDigit() }.
            totalCount += value.size
            if( value.max() > highestNumber ){
                highestNumber = value.max()
                highestCount = value.filter{ t -> t.max}.length
            }
        }
        println("Total numbers: $count.")
        println("The greatest number: $highestNumber ($highestCount time(s)).")
    }
}