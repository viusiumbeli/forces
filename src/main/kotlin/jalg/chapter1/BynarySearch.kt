package jalg.chapter1

import java.util.*

fun main() {
    val whitelist: IntArray = intArrayOf(23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68)
    Arrays.sort(whitelist)
    println(indexOf(whitelist, 14))
}

private fun indexOf(a: IntArray, key: Int): Int {
    var lo = 0
    var hi = a.size - 1
    while (lo <= hi) {
        val mid = (hi + lo) / 2
        when {
            key < a[mid] -> hi = mid - 1
            key > a[mid] -> lo = mid + 1
            else -> return mid
        }
    }
    return -1
}
/*
84
48
68
10
18
98
12
23
54
57
33
16
77
11
29
 */