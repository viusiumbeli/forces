package jalg.answers.chapter2.section5

class Exervise24(len: Int) {
    val a = IntArray(len)
    val t = IntArray(len)
    var n = 1
    var time = 1

    fun size() = n - 1

    private fun sink(k: Int) {
        var kc = k
        while (kc * 2 < n) {
            var j = kc * 2
            if (j + 1 < n && a[j] < a[j + 1])
                j++
            if (more(kc, j))
                break
            exch(a, j, kc)
            exch(t, j, kc)
            kc = j
        }
    }

    private fun swim(k: Int) {
        var kc = k
        while (kc > 1 && more(kc, kc / 2)) {
            exch(a, kc, kc / 2)
            exch(t, kc, kc / 2)
            kc /= 2
        }
    }

    private fun more(curr: Int, other: Int) =
        when {
            a[curr] == a[other] -> t[curr] > t[other]
            else -> a[curr] > a[other]
        }

    fun insert(item: Int) {
        a[n] = item
        t[n] = time++
        swim(n++)
    }

    fun delMin(): Int {
        if (size() == 0)
            throw NoSuchElementException()
        val aux = a[1]
        exch(a, 1, --n)
        exch(t, 1, n)
        t[n] = 0
        sink(1)
        return aux
    }
}

fun main() {
    val a = Exervise24(6)
    a.insert(1)
    a.insert(2)
    a.insert(2)
    a.insert(3)
    a.insert(4)
    for (i in 0 until 5)
        println(a.delMin())
}