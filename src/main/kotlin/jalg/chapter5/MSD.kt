package jalg.chapter5

class MSD(private val data: Array<String>) {
    private val R = 256

    init {
        sort(0, data.size, 0)
    }

    private fun sort(lo: Int, hi: Int, w: Int) {
        if (hi <= lo) {
            return
        }
        val count = IntArray(R)
        for (i in lo until hi) {
            count[indexOf(data[i], w) + 2]++
        }

        for (i in 0 until count.size - 2)
            count[i + 2] += count[i + 1]

        val aux = Array<String?>(data.size) { null }
        for (i in lo until hi) {
            aux[count[indexOf(data[i], w) + 1]++] = data[i]
        }
        for (i in lo until hi) {
            data[i] = aux[i - lo]!!
        }
        for (i in 0 until count.lastIndex) {
            sort(lo + count[i], lo + count[i + 1] - 1, w + 1)
        }
    }

    private fun indexOf(line: String, w: Int): Int {
        if (line.length <= w) {
            return -1
        }
        return line[w].toInt()
    }

    fun sortedData() = data
}

fun main() {
    val data = arrayOf("ab", "abc", "a", "abcd")
    val a = MSD(data)
    a.sortedData().forEach { println(it) }
}