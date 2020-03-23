package jalg.chapter3

class HashMapSep<K, V> {
    data class Node<K, V>(val key: K, var value: V, var next: Node<K, V>?)

    private val INITIAL_SIZE = 2
    private var data = Array<Node<K, V>?>(INITIAL_SIZE) { null }
    private var size = 0
    private var len = INITIAL_SIZE

    fun put(key: K, value: V) {
        val hash = hash(key)
        var first = data[hash]
        if (first == null) {
            data[hash] = Node(key, value, null)
        } else {
            while (first!!.next != null)
                first = first.next
            first.next = Node(key, value, null)
        }
        size++
        if (len == 2 * size) {
            resize(len * 2)
        }
    }

    private fun resize(newLen: Int) {
        len = newLen
        val copyData = data
        data = Array(newLen) { null }
        for (e in copyData) {
            var ce = e
            while (ce != null) {
                size--
                put(ce.key, ce.value)
                ce = ce.next
            }
        }
    }

    fun get(key: K): V? {
        val hash = hash(key)
        var first = data[hash]
        while (first != null && first.key != key)
            first = first.next
        return first?.value
    }

    fun contains(key: K) = get(key) != null

    fun remove(key: K) {
        if (!contains(key)) return
        val hash = hash(key)
        var first = data[hash] ?: return
        if (first.key == key) {
            data[hash] = first.next
        }
        while (first.next != null && first.next?.key != key)
            first = first.next!!

        if (first.next != null && first.next!!.key == key) {
            first.next = first.next!!.next
        }
        if (size * 8 == len) {
            resize(len / 2)
        }
    }

    private fun hash(key: K): Int {
        var hashCode = key.hashCode() and 0x7fffffff
        hashCode %= len
        return hashCode
    }

}

fun main() {
    val a = HashMapSep<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
    println(a.get(5))
    a.remove(5)
    println(a.get(5))
    println(a.contains(6))
}