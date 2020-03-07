package jalg.answers.chapter2.section5

fun main() {
    val a = intArrayOf(4, 5, 3, 2, 7, 6)
    println(sort(a).contentToString())
}

fun sort(a: IntArray): IntArray {
    val ind = IntArray(a.size)
    for (i in 0..a.lastIndex) {
        val aux = a[i]
        var j = i
        while (j > 0 && a[ind[j - 1]] < aux)
            ind[j] = ind[--j]
        ind[j] = i
    }
    return ind
}
