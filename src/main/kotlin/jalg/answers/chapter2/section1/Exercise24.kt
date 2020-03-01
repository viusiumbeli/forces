package jalg.answers.chapter2.section1

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1)
    var min = 0
    for (i in a.indices)
        if (a[i] < a[min])
            min = i
    val tmp = a[min]
    a[min] = a[0]
    a[0] = tmp

    for (i in 1 until a.size) {
        val c = a[i]
        var j = i
        while (a[j - 1] > c)
            a[j] = a[--j]
        a[j] = c
    }
    a.forEach { println(it) }
}
