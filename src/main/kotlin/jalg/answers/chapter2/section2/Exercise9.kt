package jalg.answers.chapter2.section2

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    val aux = IntArray(a.size)
    sort(a, aux, 0, a.lastIndex)
    a.forEach { println(it) }
}

private fun sort(a: IntArray, aux: IntArray, l: Int, h: Int) {
    if (l >= h)
        return

    val m = (l + h) / 2
    sort(a, aux, l, m)
    sort(a, aux, m + 1, h)
    merge(a, aux, l, m, h)
}

private fun merge(a: IntArray, aux: IntArray, l: Int, m: Int, h: Int) {
    for (i in l..h)
        aux[i] = a[i]

    var lc = l
    var mc = m + 1
    for (i in l..h)
        when {
            lc > m -> a[i] = aux[mc++]
            mc > h -> a[i] = aux[lc++]
            aux[mc] > aux[lc] -> a[i] = aux[lc++]
            else -> a[i] = aux[mc++]
        }
}