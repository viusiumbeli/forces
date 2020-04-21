package jalg.chapter5

class Sort(private val data: Array<String>) {
    private val r = 256
    private val result = Array<String?>(data.size) { null }

    init {
        sortData()
    }

    private fun sortData() {
        val count = IntArray(r)
        for (e in data) {
            count[e[0].toInt() + 1]++
        }

        for (i in 0 until count.size - 1) {
            count[i + 1] += count[i]
        }

        for (e in data) {
            result[count[e[0].toInt()]] = e
        }
    }

    fun result() = result

}

fun main() {
    val data = arrayOf("a", "b", "d", "e", "c")
    val a = Sort(data)
    a.result().forEach { println(it) }
}