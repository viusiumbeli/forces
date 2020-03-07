package jalg.chapter2

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1)
    for (i in a.indices)
        for (j in 1 until a.size)
            if (a[j] < a[j - 1]) {
                val tmp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = tmp
            }
    a.forEach { println(it) }
}