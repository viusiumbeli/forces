package jalg.answers.chapter1.section1

import java.util.*

fun main() {
    val d = intArrayOf(23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68)
    Arrays.sort(d)
    println(rank(d, 0, d.lastIndex, 84, 0))
}

fun rank(d: IntArray, lo: Int, hi: Int, key: Int, depth: Int): Int {
    if (lo > hi) return -1
    val mid = (lo + hi) / 2
    val ddepth = depth + 1
    System.out.printf("%${ddepth}d\n", lo)
    return when {
        key > d[mid] -> rank(d, mid + 1, hi, key, ddepth)
        key < d[mid] -> rank(d, lo, mid - 1, key, ddepth)
        else -> mid
    }
}