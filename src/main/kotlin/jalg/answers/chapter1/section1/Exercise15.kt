package jalg.answers.chapter1.section1

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5, 9, 3)
    val histogram = histogram(a, 5)
    histogram.forEach { println(it) }
}

fun histogram(a: IntArray, m: Int): Array<Int> {
    val r = Array(m) { 0 }
    for (e in a) {
        if (e < m) {
            r[e]++
        }
    }
    return r
}