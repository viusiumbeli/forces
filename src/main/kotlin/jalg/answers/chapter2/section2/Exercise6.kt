package jalg.answers.chapter2.section2

val tmp = IntArray(7) { 0 }
fun main() {
    val a = intArrayOf(6, 5, 4)
    println(sort(a, 0, a.lastIndex))
    a.forEach { println(it) }
}

private fun sort(a: IntArray, l: Int, h: Int): Int {
    if (h <= l) return 0
    val m = (l + h) / 2
    val leftA = sort(a, l, m)
    val rightB = sort(a, m + 1, h)
    merge(a, l, m, h)
    return leftA + rightB + (h - l + 1) * 4
}

private fun merge(a: IntArray, l: Int, m: Int, h: Int) {
    for (i in l..h)
        tmp[i] = a[i]

    var lc = l
    var mc = m + 1
    for (i in l..h)
        when {
            lc > m -> a[i] = tmp[mc++]
            mc > h -> a[i] = tmp[lc++]
            tmp[lc] < tmp[mc] -> a[i] = tmp[lc++]
            else -> a[i] = tmp[mc++]
        }
}
