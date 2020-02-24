package jalg.answers.chapter1.section3

class StackD<T> : Iterable<T> {
    private var first: NodeD<T>? = null

    fun push(e: T) {
        val node = NodeD(e)
        node.next = first
        if (node.next != null) {
            node.next!!.prev = node
        }
        first = node
    }

    fun pop(): T {
        if (first == null) {
            throw NoSuchElementException()
        }
        val item = first!!.item
        first = first!!.next
        first!!.prev = null
        return item
    }

    fun appendLast(e: T) {
        if (first == null) {
            first = NodeD(e)
        }
        var last = first
        while (last!!.next != null) {
            last = first!!.next
        }

        val item = NodeD(e)
        last.next = item
        item.prev = null
    }

    fun prepend(nodeD: NodeD<T>, value: T): Boolean {
        if (first == null) {
            return false
        }
        var cur = first
        if (cur!!.item == nodeD.item) {
            val copy = NodeD(value)
            copy.next = first
            first!!.prev = copy
            first = copy
            return true
        }
        while (cur!!.next != null) {
            if (cur.next!!.item == nodeD.item) {
                val copy = NodeD(value)
                copy.next = cur.next
                cur.next!!.prev = copy
                cur.next = copy
                copy.prev = cur
                return true
            }
            cur = cur.next
        }
        return false
    }

    override fun iterator(): Iterator<T> {
        return StackDIterator(first)
    }

    private class StackDIterator<T>(var first: NodeD<T>?) : Iterator<T> {
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

    data class NodeD<T>(val item: T) {
        var next: NodeD<T>? = null
        var prev: NodeD<T>? = null

    }
}