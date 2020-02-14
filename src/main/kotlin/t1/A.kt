package t1

import java.util.*

fun main() {
    val map = Scanner(System.`in`).nextLine().split(" ").map { it.toLong() }
    val (n, m, a) = map
    var result = 0L
    result += n / a + if (n % a == 0L) 0 else 1
    result *= m / a + if (m % a == 0L) 0 else 1
    println(result)
}