package jalg.answers.chapter2.section4

import edu.princeton.cs.algs4.Stopwatch
import jalg.chapter2.exch

fun main() {
    var n = 1000
    for (j in 0..2) {
        val a = IntArray(n) { it }

        val stopwatch = Stopwatch()
        for (i in n / 2 downTo 1)
            sink(a, i, n)

        val create = stopwatch.elapsedTime()

        var nc = n
        while (nc > 1) {
            exch(a, 1, --nc)
            sink(a, 1, nc)
        }

        val sort = stopwatch.elapsedTime()

        System.out.printf("%d : %.2f\n", n, create/sort*100)
        n *= 100
    }
}

private fun sink(a: IntArray, k: Int, n: Int) {
    var kc = k
    while (kc * 2 < n) {
        var j = kc * 2
        if (j + 1 < n && a[j] > a[j + 1])
            j++
        if (a[kc] < a[j])
            break
        exch(a, kc, j)
        kc = j
    }
}
