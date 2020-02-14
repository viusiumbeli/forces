package t791

import java.util.*

fun main() {
    var (a, b) = Scanner(System.`in`).nextLine().split(" ").map { it.toInt() }
    var y = 0
    while (a <= b) {
        a *= 3
        b *= 2
        y++
    }
    println(y)
}