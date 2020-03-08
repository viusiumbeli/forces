package jalg.answers.chapter3.section1

class Exercise12(len: Int) {
    var a = Array<Item?>(len) { null }
    var n = 0
    val aux = Array<Item?>(len) { null }

    constructor(elements: Array<Item?>) : this(elements.size) {
        sort(elements, 0, elements.lastIndex)
        this.a = elements
        n = elements.size
    }

    private fun sort(elements: Array<Item?>, l: Int, h: Int) {
        if (l >= h)
            return
        val m = (l + h) / 2
        sort(elements, l, m)
        sort(elements, m + 1, h)
        partition(elements, l, m, h)
    }

    private fun partition(elements: Array<Item?>, l: Int, m: Int, h: Int) {
        for (i in l..h)
            aux[i] = elements[i]

        var lc = l
        var mc = m + 1
        for (i in l..h) {
            when {
                lc > mc -> elements[i] = aux[mc++]
                mc > h -> elements[i] = aux[lc++]
                aux[mc]!!.key > aux[lc]!!.key -> elements[i] = aux[lc++]
                else -> elements[i] = aux[mc]
            }
        }
    }

    fun size() = if (n == 0) 0 else n - 1

    fun isEmpty() = n == 0

    fun min() =
        if (isEmpty())
            null
        else
            a[0]

    fun max() =
        if (isEmpty())
            null
        else
            a[n - 1]

    fun put(key: Int, value: String?) {
        if (value == null) {
            delete(key)
        }

        val rank = rank(key)
        if (rank < n && a[rank]!!.key == key)
            a[rank]!!.value = value!!
        for (i in n downTo rank)
            a[i] = a[i - 1]
        a[rank] = Item(key, value!!)
    }

    fun delete(key: Int) {
        val rank = rank(key)
        if (rank < n && a[rank]!!.key == key) {
            for (i in rank until --n)
                a[i] = a[i + 1]
            a[n] = null
        }
    }

    operator fun get(key: Int): String? {
        val rank = rank(key)
        if (rank < n && a[rank]!!.key == key)
            return a[rank]!!.value
        return null
    }

    private fun rank(key: Int): Int {
        var l = 0
        var h = n - 1
        while (l <= h) {
            val m = (l + h) / 2
            when {
                a[m]!!.key < key -> l = m + 1
                a[m]!!.key > key -> h = m - 1
                else -> return m
            }
        }
        return l
    }

    data class Item(val key: Int, var value: String)
}

fun main() {
    val d = arrayOf<Exercise12.Item?>(Exercise12.Item(1, "b"), Exercise12.Item(4, "a"))
    val a = Exercise12(d)
    println(a[4])
    println(a[1])
}