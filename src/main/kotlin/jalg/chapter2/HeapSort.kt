package jalg.chapter2

fun main() {
    val a = IntArray(10) { it }
    var n = a.lastIndex
    for (i in n / 2 downTo 1)
        sink(a, i, n)
    while (n > 1) {
        exch(a, 1, n--)
        sink(a, 1, n)
    }

    for (i in 1..a.lastIndex)
        println(a[i])
}

private fun sink(a: IntArray, k: Int, n: Int) {
    var kc = k
    while (kc * 2 <= n) {
        var j = kc * 2
        if (j < n && a[j] > a[j + 1])
            j++
        if (a[kc] < a[j])
            break
        exch(a, kc, j)
        kc = j
    }
}

fun exch(a: IntArray, l: Int, r: Int) {
    val tmp = a[l]
    a[l] = a[r]
    a[r] = tmp
}
