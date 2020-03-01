package jalg.answers.chapter2.section1

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    val n = a.size
    val indices = indices(n)
    for (h in indices) {
        for (i in 0 until n step h) {
            val tmp = a[i]
            var j = i
            while (j >= h && a[j - h] > tmp) {
                a[j] = a[j - h]
                j -= h
            }
            a[j] = tmp
        }
    }

    a.forEach { println(it) }
}

fun indices(n: Int): MutableList<Int> {
    val indices = mutableListOf<Int>()
    var h = 1
    while (h < n / 3) {
        indices.add(h)
        h = h * 3 + 1
    }
    return indices
}