package jalg.chapter2

class PriorityQueue<T : Comparable<T>>(len: Int) {
    var a: Array<T?> = arrayOfNulls<Comparable<T>>(len) as Array<T?>
    var n = 1

    fun size() = n

    private fun sink(k: Int) {
        var kc = k
        while (kc * 2 <= n) {
            var j = kc * 2
            if (j < n && a[j]!! > a[j + 1]!!)
                j++
            if (a[kc]!! < a[j]!!)
                break
            val tmp = a[j]
            a[j] = a[kc]
            a[kc] = tmp
            kc = j
        }
    }

    private fun swim(k: Int) {
        var kc = k
        while (kc > 1 && a[kc]!! < a[kc / 2]!!) {
            val tmp = a[kc]
            a[kc] = a[kc / 2]
            a[kc / 2] = tmp
            kc /= 2
        }
    }

    infix fun insert(node: T) {
        a[n] = node
        swim(n++)
    }

    fun delMin() {
        a[1] = a[--n]
        sink(1)
        a[n] = null
    }

    fun min(): T? = a[1]

}

fun main() {
    val a = PriorityQueue<Int>(6)
    a insert 6
    a insert 4
    a insert 7
    a insert 3
    for (i in 0 until 4) {
        println(a.min())
        a.delMin()
    }
}