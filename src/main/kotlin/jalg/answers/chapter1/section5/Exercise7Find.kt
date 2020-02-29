package jalg.answers.chapter1.section5

class Exercise7Find(val n: Int) {
    private var count = 0
    val data = Array(n) { it }

    private fun find(p: Int) = data[p]

    private fun connected(p: Int, q: Int) = find(p) == find(q)

    fun union(p: Int, q: Int) {
        if (connected(p, q)) return
        val pval = find(p)
        for (i in 0 until n)
            if (data[i] == pval) data[i] = find(q)
        count--
    }
}


fun main() {
    val find = Exercise7Find(10)
    with(find) {
        union(9, 0)
        union(3, 4)
        union(5, 8)
        union(7, 2)
        union(2, 1)
        union(5, 7)
        union(0, 3)
        union(4, 2)
    }
    find.data.forEach { print(it) }
}