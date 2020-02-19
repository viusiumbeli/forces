package t158

import java.util.*
import kotlin.math.max

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val d = Array(n) { sc.nextInt() }
    val fsum = d.sum()
    var ans = fsum
    if (n > 4)
        for (i in 1 until n) {
            if (n % i == 0) {
                var count = true
                var sum = 0
                for (j in 0 until n) {
                    if (count) sum += d[j]
                    if (j % i == 0) count = !count
                }
                ans = max(sum, ans)
                ans = max(fsum - sum, ans)
            }
        }
    println(ans)
}

