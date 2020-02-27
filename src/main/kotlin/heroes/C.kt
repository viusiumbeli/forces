package heroes

import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    val res = Array<Byte>(100000) { 0 }

    for (i in 0 until t) {
        val n = sc.nextInt()
        var sum = 0
        var min = Int.MAX_VALUE
        var minIndex = 0
        for (j in 0 until n) {
            val aj = sc.nextInt()
            if (aj >= 0) {
                sum += aj
                res[j] = 1
            } else
                res[j] = 0
            if (aj != 0 && abs(aj) < abs(min)) {
                min = aj
                minIndex = j
            }
        }
        sum -= abs(min)
        if (res[minIndex] == 1.toByte()) {
            res[minIndex] = 0
        } else
            res[minIndex] = 1

        println(sum)
        for (j in 0 until n) {
            print(res[j])
        }
        println()
    }
}