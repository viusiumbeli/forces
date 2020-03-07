package jalg.chapter2

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1)
    for (i in a.indices) {
        val c = a[i]
        var j = i
        while (j > 0 && a[j - 1] > c)
            a[j] = a[--j]
        a[j] = c
    }
    a.forEach { println(it) }
}