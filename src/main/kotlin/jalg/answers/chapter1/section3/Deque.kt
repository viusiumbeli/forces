package jalg.answers.chapter1.section3

class Deque<T> : Iterable<T> {
    var first: NodeD<T>? = null
    var last: NodeD<T>? = null
    var size = 0

    fun isEmpty() = size == 0

    fun size() = size

    fun pushLeft(item: T) {
        size++
        val nodeD = NodeD(item)
        nodeD.next = first
        if (first != null) {
            first!!.prev = nodeD
        }
        first = nodeD
        if (last == null) {
            last = nodeD
        }
    }

    fun pushRight(item: T) {
        size++
        val nodeD = NodeD(item)
        nodeD.prev = last
        if (last != null) {
            last!!.next = nodeD
        }
        last = nodeD
        if (first == null) {
            first = nodeD
        }
    }

    fun popRight(): T {
        size--
        if (last == null) {
            throw NoSuchElementException()
        }
        val item = last!!.item
        last = last!!.prev
        last!!.next = null

        return item
    }

    fun popLeft(): T {
        size--
        if (first == null) {
            throw NoSuchElementException()
        }
        val item = first!!.item
        first = first!!.next
        first!!.prev = null

        return item
    }

    data class NodeD<T>(val item: T) {
        var next: NodeD<T>? = null
        var prev: NodeD<T>? = null
    }

    override fun iterator() = DequeIterator(first)

    class DequeIterator<T>(var first: NodeD<T>?) : Iterator<T> {
        override fun hasNext() = first != null

        override fun next(): T {
            if (first == null) {
                throw NoSuchElementException()
            } else {
                val item = first!!.item
                first = first!!.next
                return item
            }
        }

    }
}