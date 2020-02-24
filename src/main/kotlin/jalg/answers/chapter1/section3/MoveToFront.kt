package jalg.answers.chapter1.section3

class MoveToFront<T> {
    var first: NodeM<T>? = null

    fun push(item: T) {
        val node = findNode(item)
        if (node == null) {
            val nodeM = NodeM(item)
            nodeM.next = first
            if (first != null) {
                first!!.prev = nodeM
            }
            first = nodeM
        } else {
            val prev = node.prev
            if (prev != null) {
                prev.next = node.next
                if (node.next != null) {
                    node.next!!.prev = prev
                }
                node.next = first
                node.prev = null
                if (first != null) {
                    first!!.prev = node
                }
                first = node
            }
        }
    }

    private fun findNode(item: T): NodeM<T>? {
        var cur = first
        while (cur != null) {
            if (item == cur.item) {
                return cur
            }
            cur = cur.next
        }
        return null
    }

    fun pop(): T {
        if (first == null) {
            throw NoSuchElementException()
        }
        val item = first!!.item
        first = first!!.next
        if (first != null) {
            first!!.prev = null
        }
        return item
    }


    data class NodeM<T>(val item: T) {
        var next: NodeM<T>? = null
        var prev: NodeM<T>? = null
    }
}