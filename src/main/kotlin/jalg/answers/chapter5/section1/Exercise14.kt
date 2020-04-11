package jalg.answers.chapter5.section1

class Exercise14(private val data: Array<IntArray>) {
    init {
        sort(0, data.lastIndex, 0)
    }

    private fun sort(lo: Int, hi: Int, w: Int) {
        if (lo >= hi) {
            return
        }
        var l = lo
        var r = hi
        val m = (l + r) / 2
        val p = charAt(data[m], w)
        var i = lo
        while (i <= r) {
            val t = charAt(data[i], w)
            when {
                t < p -> swap(l++, i++)
                t > p -> swap(r--, i)
                else -> i++
            }
        }

        sort(lo, l - 1, w)
        sort(l, r, w + 1)
        sort(r + 1, hi, w)
    }

    private fun swap(first: Int, second: Int) {
        val aux = data[first]
        data[first] = data[second]
        data[second] = aux
    }

    private fun charAt(s: IntArray, w: Int): Int {
        if (w < s.size) {
            return s[w]
        }
        return -1
    }

    fun sortedData() = data
}

fun main() {
    val data = arrayOf(intArrayOf(97, 98), intArrayOf(97, 98, 99), intArrayOf(97), intArrayOf(97, 98, 99, 100))
    val a = Exercise14(data)
    a.sortedData().forEach { println(it.contentToString()) }
}