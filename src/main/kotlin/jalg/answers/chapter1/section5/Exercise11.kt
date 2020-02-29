package jalg.answers.chapter1.section5

class Exercise11(val n: Int) {
    private var count = 0
    val data = Array(n) { it }
    val sz = Array(n) { 1 }

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
        if (fp == fq)
            return

        if (sz[fp] < sz[fq]) {
            data[fp] = fq
            sz[fp] += sz[fq]
        } else{
            data[fq] = fp
            sz[fq] += sz[fp]
        }

        count--
    }
}


fun main() {
    val union = Exercise11(10)
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

//4114186210
//9779396559