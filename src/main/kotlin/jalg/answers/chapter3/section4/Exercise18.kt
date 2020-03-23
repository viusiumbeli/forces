package jalg.answers.chapter3.section4

import kotlin.math.ln

class Exercise18<K, V>(val availableCompare: Int) {
    data class Node<K, V>(val key: K, var value: V, var next: Node<K, V>?)

    private val primes = intArrayOf(
        31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381, 32679, 65521, 131071, 262139, 524287, 1048573, 2097143,
        4194301, 8388593, 16777213, 33554393, 67108859, 134217689, 268435399, 536870909, 1073741789, 2147483647
    )
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
            var compares = 0
            while (first!!.next != null) {
                first = first.next
                compares++
            }
            first.next = Node(key, value, null)
            if (compares == availableCompare) {
                resize(len * 2)
            }
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
        var compares = 0
        while (first != null && first.key != key) {
            first = first.next
            compares++
        }
        if (compares > availableCompare) {
            resize(len * 2)
        }
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
        var compares = 0
        while (first.next != null && first.next?.key != key) {
            first = first.next!!
            compares++
        }
        if (first.next != null && first.next!!.key == key) {
            first.next = first.next!!.next
        }
        if (compares == availableCompare) {
            resize(len * 2)
        }
        if (size * 8 == len) {
            resize(len / 2)
        }
    }

    private fun hash(key: K): Int {
        var hash = key.hashCode() and 0x7fffffff
        if (ln(len.toDouble()) < 26) hash %= primes[ln(len.toDouble()).toInt() + 5]
        return hash % len
    }

}

fun main() {
    val a = Exercise18<Int, Int>(2)
    for (i in 0..10)
        a.put(i, i)
    println(a.get(10))
}