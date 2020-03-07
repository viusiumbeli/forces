package jalg.answers.chapter2.section5

fun main() {
    val a = intArrayOf(5, 4, 2, 6, 7)
    val par = select(a, 2)
    println(par)
}

fun select(a: IntArray, k: Int): Int {
    var l = 0
    var h = a.lastIndex
    while (h > l) {
        val j = partition(a, l, h)
        when {
            j == k -> return a[k]
            k < j -> h = j - 1
            k > j -> l = j + 1
        }
    }
    return a[k]
}

fun partition(a: IntArray, l: Int, h: Int): Int {
    val pivot = a[h]
    var lc = l
    for (i in l..h) {
        if (a[i] < pivot)
            exch(a, lc++, i)
    }
    val aux = a[lc]
    a[lc] = pivot
    a[h] = aux
    return lc
}

fun exch(a: IntArray, l: Int, h: Int) {
    val aux = a[l]
    a[l] = a[h]
    a[h] = aux
}