package jalg.answers.chapter1.section3

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.NoSuchElementException

class Stack<T> : Iterable<T> {
    private var first: Node<T>? = null

    fun isEmpty() = first == null

    fun push(item: T) {
        val node = Node(item)
        node.next = first
        first = node
    }

    fun pop(): Optional<T> =
        if (first == null) {
            Optional.empty()
        } else {
            val curr = first
            first = curr!!.next
            Optional.of(curr.item)
        }

    fun peek(): Optional<T> = if (first == null) Optional.empty() else Optional.of(first!!.item)

    fun removeLast() {
        if (first == null) {
            return
        }
        if (first!!.next == null) {
            first = null
            return
        }
        var last = first
        while (last!!.next!!.next != null)
            last = last.next
        last.next = null
    }

    fun delete(k: Int): Boolean {
        if (k < 0) throw IllegalArgumentException()
        if (first == null) {
            return false
        }
        if (k == 0) {
            first = first!!.next
            return true
        }
        var search = first
        var i = 1
        while (search!!.next != null && i < k) {
            search = search.next
            i++
        }

        if (i == k && search.next != null) {
            search.next = search.next!!.next
            return true
        }
        return false
    }

    fun newDelete(k: Int): Boolean {
        if (k < 0) throw IllegalArgumentException()
        if (first == null) return false
        if (k == 1) {
            first = first!!.next
            return true
        }
        var cur = first
        var i = 1
        while (cur!!.next != null && i < k - 1) {
            cur = cur.next
            i++
        }

        if (i == k - 1 && cur.next != null) {
            cur.next = cur.next!!.next
            return true
        }
        return false
    }

    fun find(key: T): Boolean {
        var cur = first
        while (cur != null) {
            if (cur.item == key)
                return true
            cur = cur.next
        }
        return false
    }

    fun removeAfter(node: Node<T>): Boolean {
        var cur = first
        while (cur != null) {
            if (cur.item == node.item && cur.next != null) {
                cur.next = cur.next!!.next
                return true
            }
            cur = cur.next
        }
        return false
    }

    fun insertAfter(nn: Node<T>?, a: Node<T>?): Boolean {
        if (nn == null || a == null) return false
        var cur = first
        while (cur != null) {
            if (cur.item == a.item) {
                nn.next = cur.next
                cur.next = nn
                return true
            }
            cur = cur.next
        }
        return false
    }

    fun remove(key: T) {
        if (first == null) return
        var cur = first
        while (cur?.next != null) {
            if (cur.next!!.item == key) {
                cur.next = cur.next!!.next
                continue
            }
            cur = cur.next
        }
        if (first!!.item == key)
            first = first!!.next
    }

    class Node<T>(val item: T) {
        var next: Node<T>? = null
    }

    override fun iterator(): Iterator<T> {
        return StackIterator(first)
    }

    class StackIterator<T>(private var first: Node<T>?) : Iterator<T> {

        override fun hasNext() = first != null

        override fun next(): T {
            if (first == null) {
                throw NoSuchElementException()
            } else {
                val e = first!!.item
                first = first!!.next
                return e
            }
        }

    }
}