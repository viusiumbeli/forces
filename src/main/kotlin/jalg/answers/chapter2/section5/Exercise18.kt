package jalg.answers.chapter2.section5

data class Pair18(val value: Int, val index: Int) : Comparable<Pair18> {
    override fun compareTo(other: Pair18): Int {
        return when (value) {
            other.value -> index - other.index
            else -> value - other.value
        }
    }
}

fun main() {
    val a = arrayOf(1,2,3,4,5,6,1,6)
    sort(a)
    println(a.contentToString())
}

fun sort(a: Array<Int>) {
    val d = Array(a.size) { Pair18(a[it], it) }
    sort(d)
    for (i in 0..a.lastIndex)
        a[i] = d[i].value
}

fun sort(d: Array<Pair18>) {
    for (i in 0..d.lastIndex)
        for (j in 0 until d.lastIndex)
            if (d[j] < d[j + 1]) {
                val aux = d[j]
                d[j] = d[j + 1]
                d[j + 1] = aux
            }
}
