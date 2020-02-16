package t1292

import java.util.*
import kotlin.math.abs
import kotlin.math.max


fun main() {
    val sc = Scanner(System.`in`)
    val dots = mutableListOf(Pair(sc.nextLong(), sc.nextLong()))
    val ax = sc.nextLong()
    val ay = sc.nextLong()
    val bx = sc.nextLong()
    val by = sc.nextLong()
    val xs = sc.nextLong()
    val ys = sc.nextLong()
    val t = sc.nextLong()
    var devices = 0

    val LIMIT = (1L shl 62) - 1
    while ((LIMIT - bx) / ax >= dots.last().first && (LIMIT - by) / ay >= dots.last().second) {
        dots.add(Pair(ax * dots.last().first + bx, ay * dots.last().second + by))
    }

    val xsYsDot = Pair(xs, ys)

    for (i in 0 until dots.size) {
        for (j in i until dots.size) {
            val length: Long = distanceDots(dots[i], dots[j])
            val left = distanceDots(xsYsDot, dots[i])
            val right = distanceDots(xsYsDot, dots[j])
            if (length <= t - left || length <= t - right)
                devices = max(devices, j - i + 1)
        }
    }
    println(devices)
}

fun distanceDots(pair: Pair<Long, Long>, nextDot: Pair<Long, Long>) =
    abs(pair.first - nextDot.first) + abs(pair.second - nextDot.second)

