package jalg.chapter2

import java.util.*

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1)
    sortArray(a, 0, a.lastIndex)
    Arrays.stream(a).forEach { println(it) }
}

private fun sortArray(a: IntArray, s: Int, e: Int) {
    if (s > e) return
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
//5 4 5 2 1 3