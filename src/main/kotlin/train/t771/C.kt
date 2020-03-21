package train.t771

import java.util.*

fun main() {
    with(Scanner(System.`in`)) {
        val n = nextInt()
        val k = nextInt()
        val arr = Array(n) { i -> "${(65 + i / 25).toChar()}${(97 + i % 26).toChar()}" }
        for (i in 0..n - k) {
            val legal = next() == "YES"
            if (!legal) {
                arr[i + k - 1] = arr[i]
            }
        }
        println(arr.joinToString(" "))
    }
}