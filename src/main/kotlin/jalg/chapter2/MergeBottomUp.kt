package jalg.chapter2

import kotlin.math.min


fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    sort(a)
    a.forEach { println(it) }
}

fun sort(a: IntArray) {

    var i = 1
    while (i < a.size) {

        var j = 0
        while (j + i < a.size) {
            merge(a, j, j + i - 1, min(j + i * 2 - 1, a.lastIndex))
            j += i * 2
        }

        i *= 2
    }
}

private fun merge(a: IntArray, l: Int, m: Int, h: Int) {
    for (i in l..h)
        tmp[i] = a[i]

    var lc = l
    var mc = m + 1
    for (i in l..h)
        when {
            lc > m -> a[i] = tmp[mc++]
            mc > h -> a[i] = tmp[lc++]
            tmp[lc] < tmp[mc] -> a[i] = tmp[lc++]
            else -> a[i] = tmp[mc++]
        }
}
