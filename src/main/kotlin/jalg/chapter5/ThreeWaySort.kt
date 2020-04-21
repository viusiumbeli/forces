package jalg.chapter5

class ThreeWaySort(private val data: Array<String>) {
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

    private fun charAt(s: String, w: Int): Int {
        if (w < s.length) {
            return s[w].toInt()
        }
        return -1
    }

    fun sortedData() = data
}

fun main() {
    val data = arrayOf("ab", "abc", "a", "abcd")
    val a = ThreeWaySort(data)
    a.sortedData().forEach { println(it) }
}