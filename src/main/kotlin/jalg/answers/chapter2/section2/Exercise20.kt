package jalg.answers.chapter2.section2

val aux = IntArray(7)

fun main() {
    val a = intArrayOf(6, 5, 4, 0, 2, 1, 3)
    val perm = IntArray(7) { it }
    sort(a, perm, 0, a.lastIndex)
    a.forEach { println(it) }
    println()
    perm.forEach { println(it) }
}

private fun sort(a: IntArray, perm: IntArray, l: Int, h: Int) {
    if (l >= h)
        return

    val m = (l + h) / 2
    sort(a, perm, l, m)
    sort(a, perm, m + 1, h)
    merge(a, perm, l, m, h)
}

private fun merge(a: IntArray, perm: IntArray, l: Int, m: Int, h: Int) {
    for (i in l..h)
        aux[i] = perm[i]

    var lc = l
    var mc = m + 1
    for (i in l..h)
        when {
            lc > m -> perm[i] = aux[mc++]
            mc > h -> perm[i] = aux[lc++]
            a[aux[mc]] > a[aux[lc]] -> perm[i] = aux[lc++]
            else -> perm[i] = aux[mc++]
        }
}