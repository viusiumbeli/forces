package jalg.answers.chapter2.section4


fun main() {
    val a = IntArray(7)
    for (i in 1..6)
        a[i] = i
    a[3]=2
    println(isaheap(a, 1))
}

fun isaheap(a: IntArray, i: Int): Boolean {
    if (i > a.lastIndex)
        return true
    var res = true
    if (i * 2 <= a.lastIndex)
        res = if (a[i] < a[i * 2])
            isaheap(a, i * 2)
        else
            false
    if (res && i * 2 + 1 <= a.lastIndex)
        res = if (a[i] < a[i * 2 + 1])
            isaheap(a, i * 2 + 1)
        else
            false
    return res
}
