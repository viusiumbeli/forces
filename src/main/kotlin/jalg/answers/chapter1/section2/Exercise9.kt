package jalg.answers.chapter1.section2

import edu.princeton.cs.algs4.Counter
import edu.princeton.cs.algs4.In

fun main() {
    val d = intArrayOf(1, 2, 3, 5, 6, 7)
    val c = Counter("asdf")
    binarySearch(d, 6, c)
    println(c.tally())
    println(binaryRec(d, 0, d.lastIndex, 4))
}

fun binarySearch(d: IntArray, key: Int, c: Counter): Int {
    var l = 0
    var r = d.lastIndex
    while (l <= r) {
        val mid = (l + r) / 2
        when {
            key < d[mid] -> {
                r = mid - 1
                c.increment()
            }
            key > d[mid] -> {
                c.increment()
                c.increment()
                l = mid + 1
            }
            else -> {
                c.increment()
                c.increment()
                return mid
            }
        }
    }
    return -1
}

fun binaryRec(d: IntArray, s: Int, e: Int, key: Int): Int {
    if (e <= s)
        return -1
    val mid = (s + e) / 2
    return when {
        key < d[mid] -> binaryRec(d, s, mid - 1, key)
        key > d[mid] -> binaryRec(d, mid + 1, e, key)
        else -> mid
    }
}