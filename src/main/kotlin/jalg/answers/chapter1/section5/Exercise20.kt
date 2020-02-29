package jalg.answers.chapter1.section5

class Exercise20(var n: Int) {
    private var count = 0
    var data = IntArray(n) { it }
    var len = n - 1

    fun newSite(): Int {
        len++
        if (len == n) {
            n++
            n *= 2
            resize()
        }
        return len
    }

    private fun resize() {
        val tmp = IntArray(n)
        for (i in 0..data.lastIndex)
            tmp[i] = data[i]
        if (data.lastIndex >= 0)
            for (i in data.lastIndex until n)
                tmp[i] = i
        data = tmp
    }

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
    val union = Exercise20(0)

    with(union) {
        newSite()
        newSite()
        newSite()
        newSite()
        newSite()
        newSite()
        newSite()
        newSite()
        newSite()
        union(9, 0)
        union(3, 4)
        union(5, 8)
        union(7, 2)
        union(2, 1)
        union(5, 7)
        union(0, 3)
        union(9, 2)
    }
    for (i in 0..union.len + 1)
        print(union.data[i])
}
