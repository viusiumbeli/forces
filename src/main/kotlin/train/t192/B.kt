package train.t192

import java.util.*
import kotlin.math.max

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val l = sc.nextInt()
    val a = Array(n) { sc.nextInt() }
    sortArray(a, 0, a.lastIndex)
    var mD = 0
    for (i in 1..a.lastIndex) mD = max(mD, a[i] - a[i - 1])
    var ans: Double = mD.toDouble() / 2F
    ans = max(a[0].toDouble(), ans)
    ans = max((l - a.last()).toDouble(), ans)
    System.out.printf("%.9f", ans)
}

fun sortArray(a: Array<Int>, s: Int, e: Int) {
    val m = s + (e - s) / 2
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