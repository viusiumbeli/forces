package jalg.answers.chapter3.section2

class Exercise6_2<K : Comparable<K>, V> {
    data class Node<K, V>(
        val key: K,
        var value: V,
        var size: Int,
        var height: Int,
        var left: Node<K, V>?,
        var right: Node<K, V>?
    )

    var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun isEmpty() = size() == 0

    fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V>? {
        when {
            node == null -> return Node(k, v, 0, 1, null, null)
            node.key > k -> node.left = put(node.left, k, v)
            node.key < k -> node.right = put(node.right, k, v)
            else -> node.value = v
        }
        node.size = size(node.left) + 1 + size(node.right)
        node.height = kotlin.math.max(height(node.left) + 1, height(node.right) + 1)
        return node
    }

    private fun height(node: Node<K, V>?) = node?.height ?: 0

    fun height() = height(root)

    fun deleteMin() {
        if (root != null) {
            root = deleteMin(root!!)
        }
    }

    private fun deleteMin(node: Node<K, V>): Node<K, V>? {
        if (node.left == null) {
            return node.right
        }
        node.left = deleteMin(node.left!!)
        node.size = size(node.left) + 1 + size(node.right)
        node.height = kotlin.math.max(height(node.left) + 1, height(node.right) + 1)
        return node
    }
}


fun main() {
    val a = Exercise6_2<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    a.put(8, "7")
    a.put(9, "0")
    a.put(2, "0")
    a.put(1, "0")
    println(a.height())
    a.deleteMin()
    println(a.height())
}