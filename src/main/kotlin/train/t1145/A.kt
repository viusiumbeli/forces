package train.t1145

import java.util.*

fun main() {
    val a = with(Scanner(System.`in`)) {
        val n = nextInt()
        return@with Array(n) { nextInt() }
    }
    if (checkSorted(a)) {
        println(a.size)
    } else {
        println(maxSorted(a))
    }
}

fun maxSorted(a: Array<Int>): Int {
    val leftArray = a.sliceArray(0..a.size / 2)
    if (checkSorted(leftArray)) {
        return a.size / 2
    }

    val rightArray = a.sliceArray((a.size / 2) until a.size)
    if (checkSorted(rightArray)) {
        return a.size / 2
    }
    return maxSorted(leftArray).coerceAtLeast(maxSorted(rightArray))
}

fun checkSorted(subarray: Array<Int>): Boolean {
    var prev = Int.MIN_VALUE
    for (e in subarray) {
        if (e >= prev) {
            prev = e
        } else {
            return false
        }
    }
    return true
}
