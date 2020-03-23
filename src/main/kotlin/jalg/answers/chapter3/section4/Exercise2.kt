package jalg.answers.chapter3.section4

class Exercise2<K, V> {
    data class Node<K, V>(val key: K, var value: V, var sec: Int)

    private val INITIAL_SIZE = 2
    private var data = ArrayList<MutableList<Node<K, V>>>(INITIAL_SIZE)
    private var size = 0
    private var len = INITIAL_SIZE

    init {
        initData()
    }

    private fun initData() {
        for (i in 0..len)
            data.add(mutableListOf())
    }

    fun put(key: K, value: V) {
        put(key, value, ++size)
        if (size == len * 2) {
            resize(len * 2)
        }
    }

    private fun resize(newLen: Int) {
        val cdata = data
        data = ArrayList(newLen)
        initData()
        len = newLen
        for (e in cdata) {
            for (n in e) {
                put(n.key, n.value, n.sec)
            }
        }
    }

    private fun put(key: K, value: V, sec: Int) {
        val hash = hash(key)
        data[hash].add(Node(key, value, sec))
    }

    fun remove(key: K) {
        val hash = hash(key)
        val iterator = data[hash].iterator()
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove()
                size--
                break
            }
        }
        if (size * 8 == len) {
            resize(len / 2)
        }
    }

    fun get(key: K): V? {
        val hash = hash(key)
        val iterator = data[hash].iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next.key == key) {
                return next.value
            }
        }
        return null
    }

    private fun hash(key: K): Int {
        var hash = key.hashCode() and 0x7fffffff
        hash %= len
        return hash
    }

}

fun main() {
    val a = Exercise2<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
    a.put(7, 7)
    println(a.get(3))
    a.remove(3)
    println(a.get(3))
}