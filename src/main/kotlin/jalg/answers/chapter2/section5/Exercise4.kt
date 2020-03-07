package jalg.answers.chapter2.section5

fun main() {
    val n = 10
    val a = Array(n) { (Math.random() * 10).toInt().toString() }
    println(a.contentToString())
    sorta(a, 0, a.lastIndex)
    println(a.contentToString())
    val uniqueEl = filterUnique(a)
    for (i in 0..uniqueEl)
        println(a[i])
}

private fun filterUnique(a: Array<String>): Int {
    var c = 0
    for (e in a)
        if (a[c] != e)
            a[++c] = e
    return c
}

private fun sorta(a: Array<String>, l: Int, h: Int) {
    if (l > h)
        return
    val pivot = a[(l + h) / 2]
    var lc = l
    var hc = h
    while (lc <= hc) {
        while (a[lc] < pivot) lc++
        while (a[hc] > pivot) hc--
        if (lc <= hc) {
            exch(a, lc++, hc--)
        }
    }
    sorta(a, lc, h)
    sorta(a, l, hc)
}

fun exch(a: Array<String>, lc: Int, hc: Int) {
    val tmp = a[lc]
    a[lc] = a[hc]
    a[hc] = tmp
}
