package jalg

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = Array(n) { sc.nextInt() }
    sortArray(a, 0, a.lastIndex)
    Arrays.stream(a).forEach { println(it) }
}

fun sortArray(a: Array<Int>, s: Int, e: Int) {
    val m = e
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
    if (s < r) sortArray(a, s, r)
    if (l < e) sortArray(a, l, e)
}
//5 4 5 2 1 3