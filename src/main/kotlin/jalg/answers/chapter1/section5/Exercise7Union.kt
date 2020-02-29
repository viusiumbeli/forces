package jalg.answers.chapter1.section5

class Exercise7Union(val n: Int) {
    private var count = 0
    val data = Array(n) { it }

    private fun find(p: Int): Int {
        var pc = p
        while (data[pc] != pc)
            pc = data[pc]
        return pc
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
    val union = Exercise7Union(10)
    with(union) {
        union(9, 0)
        union(3, 4)
        union(5, 8)
        union(7, 2)
        union(2, 1)
        union(5, 7)
        union(0, 3)
        union(4, 2)
    }
    union.data.forEach { print(it) }
}