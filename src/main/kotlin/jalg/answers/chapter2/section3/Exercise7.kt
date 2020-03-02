package jalg.answers.chapter2.section3

fun main() {
    val a = intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5)
    println(sort(a, 0, a.lastIndex))
    println()
    a.forEach { println(it) }
}

private fun sort(a: IntArray, l: Int, h: Int): Int {
    if (l >= h)
        return 0
    var lc = l
    var hc = h
    val m = (l + h) / 2
    val pivot = a[m]
    while (lc <= hc) {
        while (a[lc] < pivot) lc++
        while (a[hc] > pivot) hc--
        if (hc >= lc) {
            val tmp = a[lc]
            a[lc++] = a[hc]
            a[hc--] = tmp
        }
    }
    val sleft = sort(a, lc, h)
    val sright = sort(a, l, hc)
    return sleft + sright + (if (h - l <= 3) 1 else 0)
}