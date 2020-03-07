package jalg.chapter2

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1, 7, 8, 9, 0)
    var h = 1
    val n = a.size
    while (h < n / 3) h = h * 3 + 1

    while (h >= 1) {
        for (i in 0 until n step h) {
            val tmp = a[i]
            var j = i
            while (j >= h && a[j - h] > tmp) {
                a[j] = a[j - h]
                j -= h
            }
            a[j] = tmp
        }
        h /= 3
    }

    a.forEach { println(it) }
}