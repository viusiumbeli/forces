package jalg.answers.chapter1.section5

class Exercise12(val n: Int) {
    private var count = 0
    val data = Array(n) { it }

    private fun find(p: Int): Int {
        if (p == data[p])
            return p
        data[p] = find(data[p])
        return data[p]
    }

    private fun connected(p: Int, q: Int) = find(p) == find(q)

    fun union(p: Int, q: Int) {
        val fp = find(p)
        val fq = find(q)
        if (fp != fq) {
            data[fp] = data[fq]
            count--
        }
    }
}


fun main() {
    val union = Exercise12(10)
    with(union) {
        union(9, 0)
        union(3, 4)
        union(5, 8)
        union(7, 2)
        union(2, 1)
        union(5, 7)
        union(0, 3)
        union(9, 2)
    }
    union.data.forEach { print(it) }
}