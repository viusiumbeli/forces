package jalg.answers.chapter3.section1

class Exercise1 {
    private val keys = arrayOf("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F")
    private val values = arrayOf(4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00)

    fun size() = keys.size

    fun isEmpty() = size() == 0

    fun min() = values[0]

    fun max() = values.last()

    operator fun get(key: String): Double? {
        if (keys.isEmpty())
            throw NoSuchElementException()

        val rank = rank(key)
        if (rank < keys.size && key == keys[rank])
            return values[rank]
        return null
    }

    private fun rank(key: String): Int {
        var l = 0
        var h = keys.lastIndex
        while (l <= h) {
            val m = (l + h) / 2
            val compare = compare(key, keys[m])
            when {
                compare < 0 -> h = m - 1
                compare > 0 -> l = m + 1
                else -> return m
            }
        }
        return l
    }

    private fun compare(l: String, h: String): Int {
        return when {
            l == h -> 0
            l[0] == h[0] -> {
                return if (l.length == 2)
                    if (l[1] == '+') -1 else 1
                else
                    if (h[1] == '+') 1 else -1
            }
            else -> l[0] - h[0]
        }
    }
}

fun main() {
    val a = Exercise1()
    println((a["A+"]!! + a["B"]!!) / 2)
}