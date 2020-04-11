package jalg.answers.chapter5.section1

import jalg.chapter5.Alphabet

class Exercise1(private val data: Array<String>) {
    private val alphabet = Alphabet(data)
    private var result = Array<String?>(data.size) { null }

    init {
        sortData()
    }

    private fun sortData() {
        val count = IntArray(alphabet.radix() + 1)
        for (e in data) {
            count[alphabet.toIndex(e[0]) + 1]++
        }

        for (i in 0 until count.lastIndex) {
            count[i + 1] += count[i]
        }

        for (e in data) {
            result[count[alphabet.toIndex(e[0])]] = e
        }
    }

    fun result() = result
}

fun main() {
    val data = arrayOf("a", "b", "d", "e", "c")
    val a = Exercise1(data)
    a.result().forEach { println(it) }
}