package jalg.chapter2

val tmp = IntArray(7) { 0 }
fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1,0)
    sort(a, 0, a.lastIndex)
    a.forEach { println(it) }
}

fun sort(a: IntArray, l: Int, h: Int) {
    if (l >= h)
        return
    val m = (l + h) / 2
    sort(a, l, m)
    sort(a, m + 1, h)
    merge(a, l, m, h)
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
