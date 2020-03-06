package jalg.answers.chapter2.section4

import kotlin.math.min

class Exercise2SortedArray(val size: Int) {
    val a = IntArray(size)
    var n = 0

    infix fun insert(key: Int) {
        var i = 0
        while (i < n && a[i] > key)
            i++
        for (j in n downTo i + 1)
            a[j] = a[j - 1]
        a[i] = key
        n = min(++n, size - 1)
    }

    fun max(): Int {
        if (n == 0)
            throw NoSuchElementException()

        return a[0]
    }

}

fun main() {
    val a = Exercise2SortedArray(3)
    a insert 3
    a insert 2
    a insert 1
    a insert 1
    a insert 2
    a insert 3
    a insert 4
    a insert 5
    a insert 6
    println(a.a.contentToString())
}