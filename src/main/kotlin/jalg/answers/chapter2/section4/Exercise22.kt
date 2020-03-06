package jalg.answers.chapter2.section4

class RPriorityQueue {
    var a = IntArray(2)
    var n = 1

    private fun swim(k: Int) {
        var kc = k
        while (kc >= 1 && a[kc] < a[kc / 2]) {
            swap(kc, kc / 2)
            kc /= 2
        }
    }

    private fun sink(k: Int) {
        var kc = k
        while (kc * 2 < n) {
            var j = kc * 2
            if (j < n - 1 && a[j] > a[j + 1])
                j++
            if (a[j] > a[kc])
                break
            swap(kc, j)
            kc = j
        }
    }

    infix fun insert(item: Int) {
        a[n] = item
        swim(n++)
        if (n == a.size)
            resize(a.size * 2)
    }

    fun delMax(): Int {
        if (n == 1)
            throw NoSuchElementException()

        val res = a[1]
        a[1] = a[--n]
        sink(1)

        if (a.size / 4 == n)
            resize(a.size / 2)

        return res
    }

    private fun resize(newSize: Int) {
        val tmp = IntArray(newSize)
        for (i in 0 until n)
            tmp[i] = a[i]
        a = tmp
    }

    private fun swap(l: Int, r: Int) {
        val tmp = a[l]
        a[l] = a[r]
        a[r] = tmp
    }
}

fun main() {
    val a = RPriorityQueue()

    a insert 4
    a insert 3
    a insert 5
    a insert 6
    a insert 7
    a insert 1
    println(a.delMax())
    println(a.delMax())
    println(a.delMax())
    println(a.delMax())
    println(a.delMax())
    println(a.delMax())
}