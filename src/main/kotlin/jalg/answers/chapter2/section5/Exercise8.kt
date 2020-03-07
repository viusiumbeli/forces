package jalg.answers.chapter2.section5

import java.util.*

val aux = arrayOfNulls<String>(9)

private data class Pair(val count: Int, val word: String) : Comparable<Pair> {
    override fun compareTo(other: Pair) = this.count - other.count
}

fun main() {
    val a = arrayOf("1", "1", "1", "2", "2", "2", "2", "3", "4")
    sort(a, 0, a.lastIndex)
    println(a.contentToString())
    val filterUnique = filterUnique(a)
    Arrays.sort(filterUnique) { o1: Pair, o2: Pair -> o2.count - o1.count }
    for (e in filterUnique)
        println(e)
}

private fun filterUnique(a: Array<String>): Array<Pair> {
    if (a.isEmpty())
        return arrayOf()
    val list = mutableListOf<Pair>()

    var curr = a[0]
    var len = 1
    for (e in a)
        when {
            e != curr -> {
                list.add(Pair(len, curr))
                curr = e
                len = 1
            }
            else -> len++
        }
    return list.toTypedArray()
}

fun sort(a: Array<String>, l: Int, h: Int) {
    if (h <= l)
        return

    val m = (l + h) / 2
    sort(a, l, m)
    sort(a, m + 1, h)
    merge(a, l, m, h)
}

fun merge(a: Array<String>, l: Int, m: Int, h: Int) {
    for (i in l..h)
        aux[i] = a[i]

    var lc = l
    var mc = m + 1
    for (i in l..h) {
        when {
            lc > m -> a[i] = aux[mc++]!!
            mc > h -> a[i] = aux[lc++]!!
            aux[lc]!! > aux[mc]!! -> a[i] = aux[lc++]!!
            else -> a[i] = aux[mc++]!!
        }
    }
}
