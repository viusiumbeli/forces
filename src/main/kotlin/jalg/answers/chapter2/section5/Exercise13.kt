package jalg.answers.chapter2.section5

data class Pair13(val task: String, val duration: Int) : Comparable<Pair13> {
    override fun compareTo(other: Pair13) = this.duration - other.duration
}

fun main() {
    val a = arrayOf(Pair13("a", 3), Pair13("b", 2), Pair13("g", 4))
    sort(a)
    for (i in 0..1)
        println(a[i])
}

private fun sort(a: Array<Pair13>) {
    for (i in 0..a.lastIndex) {
        var j = i
        val aux = a[i]
        while (j > 0 && a[j - 1] < aux)
            a[j] = a[--j]
        a[j] = aux
    }
}