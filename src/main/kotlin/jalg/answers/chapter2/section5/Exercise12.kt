package jalg.answers.chapter2.section5

data class Pair12(val task: String, val duration: Int) : Comparable<Pair12> {
    override fun compareTo(other: Pair12) = this.duration - other.duration
}

fun main() {
    val a = arrayOf(Pair12("a", 2), Pair12("b", 3), Pair12("c", 1), Pair12("f", 4))
    sort(a)
    for (e in a)
        println(e)
}

private fun sort(a: Array<Pair12>) {
    for (i in 0..a.lastIndex) {
        var mini = i
        for (j in i..a.lastIndex)
            if (a[j] < a[mini])
                mini = j
        val aux = a[mini]
        a[mini] = a[i]
        a[i] = aux
    }
}
