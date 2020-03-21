package jalg.answers.chapter3.section2

class Exercise34<K : Comparable<K>, V> {
    data class Node<K, V>(
        val key: K,
        var value: V,
        var size: Int,
        var left: Node<K, V>?,
        var right: Node<K, V>?,
        var pred: Node<K, V>?,
        var succ: Node<K, V>?
    )

    private var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun put(k: K, v: V) {
        root = put(root, k, v, null, null)
    }

    private fun put(node: Node<K, V>?, k: K, v: V, pred: Node<K, V>?, succ: Node<K, V>?): Node<K, V>? {
        when {
            node == null -> {
                val nnode = Node(k, v, 1, null, null, pred, succ)
                pred?.succ = nnode
                succ?.pred = nnode
                return nnode
            }
            node.key == k -> node.value = v
            node.key > k -> node.left = put(node.left, k, v, pred, node)
            else -> node.right = put(node.right, k, v, node, succ)
        }

        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    fun deleteMin() {
        if (root == null)
            return
        root = deleteMin(root!!, null)
    }

    private fun deleteMin(node: Node<K, V>, succ: Node<K, V>?): Node<K, V>? {
        if (node.left == null) {
            if (node.succ != null) {
                node.succ!!.pred = null
            }
            return node.right
        }
        node.left = deleteMin(node.left!!, node)
        return node
    }
}

fun main() {
    val a = Exercise34<Int, String>()
    a.put(4, "5")
    a.put(1, "5")
    a.put(2, "3")
    a.put(3, "7")
    a.put(5, "8")
    a.deleteMin()
}