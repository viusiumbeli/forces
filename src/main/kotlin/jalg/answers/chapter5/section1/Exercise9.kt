package jalg.answers.chapter5.section1

import kotlin.math.max

class Exercise9(private val data: Array<String>) {
    private val sorted = Array<String?>(data.size) { null }
    private val R = 256

    init {
        sortData()
        for (i in data.indices) {
            sorted[i] = data[i]
        }
    }

    private fun sortData() {
        var maxLen = Int.MIN_VALUE
        for (e in data)
            maxLen = max(maxLen, e.length)

        for (i in maxLen - 1 downTo 0) {
            val count = IntArray(R)
            for (e in data) {
                count[indexOf(e, i) + 2]++
            }

            for (j in 0 until count.size - 2) {
                count[j + 2] += count[j + 1]
            }

            val aux = Array<String?>(data.size) { null }
            for (e in data) {
                aux[count[indexOf(e, i) + 1]++] = e
            }
            for (j in aux.indices) {
                data[j] = aux[j]!!
            }
        }
    }

    private fun indexOf(line: String, i: Int): Int {
        if (line.length <= i)
            return -1
        return line[i].toInt()
    }

    fun sortedData() = sorted
}

fun main() {
    val data = arrayOf("ab", "abc", "a", "abcd")
    val a = Exercise9(data)
    a.sortedData().forEach { println(it) }
}