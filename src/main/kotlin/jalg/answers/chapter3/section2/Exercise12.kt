package jalg.answers.chapter3.section2

class Exercise12<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var left: Node<K, V>?, var right: Node<K, V>?)

    var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?): Int {
        if (node == null) {
            return 0
        }
        return size(node.left) + 1 + size(node.right)
    }

    fun isEmpty() = size() == 0

    fun get(k: K) = get(root, k)?.value

    private fun get(node: Node<K, V>?, k: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key < k -> get(node.right, k)
            else -> get(node.left, k)
        }

    fun contains(k: K) = get(k) == null

    fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V>? {
        when {
            node == null -> return Node(k, v, null, null)
            node.key == k -> node.value = v
            node.key > k -> node.left = put(node.left, k, v)
            else -> node.right = put(node.right, k, v)
        }
        return node
    }

    fun min(): Node<K, V>? {
        if (root == null) {
            return null
        }
        return min(root!!)
    }

    fun min(node: Node<K, V>): Node<K, V>? {
        if (node.left == null) {
            return node
        }
        return min(node.left!!)
    }

    fun max(): Node<K, V>? {
        if (root == null) {
            return null
        }
        return max(root!!)
    }

    fun max(node: Node<K, V>): Node<K, V> {
        if (node.right == null) {
            return node
        }
        return node.right!!
    }

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
        return node
    }

    fun deleteMax() {
        if (root != null) {
            root = deleteMax(root!!)
        }
    }

    private fun deleteMax(node: Node<K, V>): Node<K, V>? {
        if (node.right == null) {
            return node.left
        }
        node.right = deleteMax(node.right!!)
        return node
    }

    fun floor(k: K): K? {
        return floor(root, k)
    }

    private fun floor(node: Node<K, V>?, k: K): K? =
        when {
            node == null -> null
            node.key > k -> floor(node.left, k)
            else -> floor(node.right, k) ?: node.key
        }

    fun ceiling(k: K) = ceiling(root, k)

    private fun ceiling(node: Node<K, V>?, k: K): K? =
        when {
            node == null -> null
            node.key < k -> ceiling(node.right, k)
            else -> ceiling(node.left, k) ?: node.key
        }
}

fun main() {
    val a = Exercise12<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    println(a.size())
    println(a.isEmpty())
    println(a.min())
    println(a.max())
    a.deleteMin()
    println(a.min())
    a.put(2, "8")
    a.deleteMax()
    println(a.max())
    println(a.floor(4))
    println(a.floor(1))
    println(a.ceiling(4))
    println(a.ceiling(1))
}