package jalg.answers.chapter3.section3

class Exercise29<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var size: Int, var left: Node<K, V>?, var right: Node<K, V>?)

    private var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun get(key: K) = get(root, key)?.value

    private fun get(node: Node<K, V>?, key: K): Node<K, V>? {
        val min = minChild(node)
        val max = maxChild(node)
        return when {
            node == null -> null
            node.key == key -> node
            node.key > key -> get(min, key)
            else -> get(max, key)
        }
    }

    private fun maxChild(node: Node<K, V>?): Node<K, V>? {
        if (node?.left != null && node.right != null) {
            return if (node.left!!.key > node.right!!.key)
                node.left
            else
                node.right
        }
        return node?.right
    }

    private fun minChild(node: Node<K, V>?): Node<K, V>? {
        if (node?.left != null && node.right != null) {
            return if (node.left!!.key < node.right!!.key) {
                node.left
            } else
                node.right
        }
        return node?.left
    }

    fun put(key: K, value: V) {
        root = put(root, key, value)
    }

    private fun put(node: Node<K, V>?, key: K, value: V): Node<K, V>? {
        val min = minChild(node)
        val max = maxChild(node)
        when {
            node == null -> return Node(key, value, 0, null, null)
            node.key == key -> node.value = value
            node.key > key -> node.left = put(min, key, value)
            else -> node.right = put(max, key, value)
        }
        var nodec = node
        if (isRed(node.left) && isRed(node.right) && less(node)) flipColors(node)
        if (isRed(node.right) && less(node)) nodec = rotateLeft(node)
        if (isRed(node.left) && isRed(node.left?.left)) nodec = rotateRight(node)
        nodec?.size = size(nodec?.left) + 1 + size(nodec?.right)
        return nodec
    }

    private fun less(node: Node<K, V>): Boolean {
        if (node.right != null && node.left != null && node.left!!.key < node.right!!.key) {
            return true
        }
        if (node.right == null || node.left == null) {
            return true
        }
        return false
    }


    private fun rotateRight(node: Node<K, V>): Node<K, V>? {
        val x = node.left!!
        node.left = x.right
        x.left = node
        x.size = node.size
        node.size = size(node.left) + 1 + size(node.right)
        return x
    }

    private fun flipColors(node: Node<K, V>) {
        val left = node.left
        node.left = node.right
        node.right = left
    }

    private fun rotateLeft(node: Node<K, V>): Node<K, V>? {
        val x = node.right!!
        node.right = x.left
        x.left = node
        x.size = node.size
        node.size = size(node.left) + 1 + size(node.right)
        return x
    }

    private fun isRed(node: Node<K, V>?): Boolean {
        if (node == null) {
            return false
        }

        if (node.left == null || node.right == null || node.left!!.key > node.right!!.key) {
            return true
        }
        return false
    }
}

fun main() {
    val a = Exercise29<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
}