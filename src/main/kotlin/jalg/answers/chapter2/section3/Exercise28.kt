package jalg.answers.chapter2.section3

import kotlin.math.max

fun main() {
    for (i in listOf(10, 20, 50)) {
        for (j in listOf(1000, 10_000, 100_000, 1_000_000)) {
            val a = IntArray(j) { it }
            val sort = sort(a, 0, a.lastIndex, i)
            System.out.printf("$i   = $j   : $sort\n")
        }
    }
}

private fun sort(a: IntArray, l: Int, h: Int, m: Int): Int {
    if (h <= l || h - l < m)
        return 0

    var lc = l
    var hc = h
    val pivot = a[(l + h) / 2]
    while (lc <= hc) {
        while (a[lc] < pivot) lc++
        while (a[hc] > pivot) hc--
        if (lc <= hc) {
            val tmp = a[lc]
            a[lc++] = a[hc]
            a[hc--] = tmp
        }
    }
    val ldeep = sort(a, lc, h, m) + 1
    val rdeep = sort(a, l, hc, m) + 1
    return max(ldeep, rdeep)
}