package jalg.answers.chapter2.section3

import edu.princeton.cs.algs4.Stopwatch

fun main() {
    var i = 1_000
    while (i <= 1_00_000_000) {
        val a = IntArray(i) { (Math.random() * i).toInt() }
        val b = a.copyOf()
        var s = Stopwatch()
        sort(a, 0, a.lastIndex)
        insort(a)
        val detached = s.elapsedTime()
        s = Stopwatch()
        sortArray(b, 0, a.lastIndex)
        val common = s.elapsedTime()
        System.out.printf("$i   = $detached   : $common\n")
        i *= 10
    }
}

private fun sort(a: IntArray, l: Int, h: Int) {
    if (h <= l || h - l < 28)
        return

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
    sort(a, lc, h)
    sort(a, l, hc)
}

private fun insort(a: IntArray) {
    for (i in a.indices) {
        val c = a[i]
        var j = i
        while (j > 0 && a[j - 1] > c)
            a[j] = a[--j]
        a[j] = c
    }
}

private fun sortArray(a: IntArray, s: Int, e: Int) {
    if (s >= e) return
    val m = (s + e) / 2
    val pivot = a[m]
    var l = s
    var r = e
    while (l <= r) {
        while (a[l] < pivot) l++
        while (a[r] > pivot) r--
        if (l <= r) {
            val temp = a[r]
            a[r] = a[l]
            a[l] = temp
            l++
            r--
        }
    }
    sortArray(a, s, r)
    sortArray(a, l, e)
}