package jalg.answers.chapter2.section3

import edu.princeton.cs.algs4.StdRandom
import edu.princeton.cs.algs4.Stopwatch

fun main() {
    val full = hashMapOf(1 to DoubleArray(1_000) { StdRandom.uniform() },
        2 to DoubleArray(10_0000) { StdRandom.uniform() },
        3 to DoubleArray(100_000) { StdRandom.uniform() },
        4 to DoubleArray(1_000_000) { StdRandom.uniform() })

    for (j in 0..30) {
        var totalTime = 0.0
        for (i in 1..4) {
            val a = full[i]!!
            val s = Stopwatch()
            sort(a, 0, a.lastIndex, j)
            totalTime += s.elapsedTime()
        }
        System.out.printf("$j  = $totalTime\n")
    }
}

private fun sort(a: DoubleArray, l: Int, h: Int, m: Int) {
    if (h <= l)
        return

    var lc = l
    var hc = h
    if (h - l < m) {
        insort(a, l, h)
        lc = h
        hc = l
    } else {
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
    }
    sort(a, lc, h, m)
    sort(a, l, hc, m)
}

private fun insort(a: DoubleArray, l: Int, h: Int) {
    for (i in l..h) {
        val c = a[i]
        var j = i
        while (j > l && a[j] < c)
            a[j + 1] = a[j--]
        a[j] = c
    }
}