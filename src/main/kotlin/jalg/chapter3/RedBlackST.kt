package jalg.chapter3

open class RedBlackST<K : Comparable<K>, V> {
    data class Node<K, V>(
        val key: K,
        var value: V,
        var size: Int,
        var color: Boolean,
        var left: Node<K, V>?,
        var right: Node<K, V>?
    )

    protected var root: Node<K, V>? = null

    fun size() = size(root)

    fun size(node: Node<K, V>?) = node?.size ?: 0

    fun isEmpty() = size() == 0

    fun get(key: K) = get(root, key)?.value

    fun get(node: Node<K, V>?, key: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == key -> node
            node.key < key -> get(node.right, key)
            else -> get(node.left, key)
        }

    fun contains(key: K) = get(key) != null

    fun put(key: K, value: V) {
        root = put(root, key, value)
        root?.color = BLACK
    }

    fun put(node: Node<K, V>?, key: K, value: V): Node<K, V>? {
        when {
            node == null -> return Node(key, value, 1, true, null, null)
            node.key == key -> node.value = value
            node.key > key -> node.left = put(node.left, key, value)
            else -> node.right = put(node.right, key, value)
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node)
        }
        var nodec = node
        if (isRed(nodec.right)) {
            nodec = rotateLeft(nodec)
        }
        if (isRed(nodec.left) && isRed(nodec.left?.left)) {
            nodec = rotateRight(nodec)
        }
        nodec.size = size(nodec.left) + 1 + size(nodec.right)
        return nodec
    }

    private fun flipColor(node: Node<K, V>) {
        node.color = RED
        node.left?.color = BLACK
        node.right?.color = BLACK
    }

    protected fun isRed(node: Node<K, V>?) = node?.color == RED

    private fun rotateLeft(node: Node<K, V>): Node<K, V> {
        val x = node.right!!
        node.right = x.left
        x.left = node
        x.color = node.color
        node.color = RED
        x.size = node.size
        node.size = size(node.left) + 1 + size(node.right)
        return x
    }

    private fun rotateRight(node: Node<K, V>): Node<K, V> {
        val x = node.left!!
        node.left = x.right
        x.right = node
        x.color = node.color
        node.color = RED
        x.size = node.size
        node.size = size(node.left) + 1 + size(node.right)
        return x
    }

    fun min(): K? {
        if (root == null) {
            return null
        }
        return min(root!!).key
    }

    private fun min(node: Node<K, V>): Node<K, V> {
        if (node.left == null) {
            return node
        }
        return min(node.left!!)
    }

    private fun max(): K? {
        if (root == null)
            return null
        return max(root!!).key
    }

    private fun max(node: Node<K, V>): Node<K, V> {
        if (node.right == null) {
            return node
        }
        return max(node.right!!)
    }

    fun floor(key: K) = floor(root, key)?.key

    private fun floor(node: Node<K, V>?, key: K): Node<K, V>? =
        when {
            node == null -> null
            node.key > key -> floor(node.left, key)
            node.key == key -> node
            else -> {
                val aux = floor(node.right, key)
                aux ?: node
            }
        }

    fun ceiling(key: K) = ceiling(root, key)?.key

    private fun ceiling(node: Node<K, V>?, key: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == key -> node
            node.key < key -> ceiling(node.right, key)
            else -> {
                val aux = ceiling(node.left, key)
                aux ?: node
            }
        }

    fun select(rank: Int): K? {
        return select(root, rank)?.key
    }

    private fun select(node: Node<K, V>?, rank: Int): Node<K, V>? {
        val lsize = size(node?.left)
        return when {
            node == null -> null
            lsize == rank -> node
            lsize > rank -> select(node.left, rank)
            else -> select(node.right, rank - lsize - 1)
        }
    }

    fun rank(key: K): Int {
        return rank(root, key)
    }

    private fun rank(node: Node<K, V>?, key: K): Int =
        when {
            node == null -> 0
            node.key == key -> size(node.left)
            node.key > key -> rank(node.left, key)
            else -> rank(node.right, key) + size(node.left) + 1
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
        var balance = node
        if (isRed(balance.left) && isRed(balance.right)) {
            flipColor(balance)
        }
        if (isRed(balance.right)) {
            balance = rotateLeft(balance)
        }
        if (isRed(balance.left) && isRed(balance.left?.left)) {
            balance = rotateRight(balance)
        }
        balance.size = size(balance.left) + 1 + size(balance.right)
        return balance
    }

    companion object {
        private const val RED = true
        private const val BLACK = false
    }
}

fun main() {
    val a = RedBlackST<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
    a.put(7, 7)
    a.put(8, 8)
    a.put(9, 9)
    println(a.rank(9))
}