package jalg.chapter2

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1)
    for (i in a.indices) {
        var min = i
        for (j in i + 1 until a.size)
            if (a[j] < a[min])
                min = j
        val tmp = a[min]
        a[min] = a[i]
        a[i] = tmp
    }
    a.forEach { println(it) }
}