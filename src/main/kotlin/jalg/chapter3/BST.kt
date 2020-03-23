package jalg.chapter3

import edu.princeton.cs.algs4.Queue

class BST<K : Comparable<K>, V> : SearchTree<K, V> {
    var root: Node<K, V>? = null

    data class Node<K, V>(
        val key: K,
        var value: V,
        var size: Int,
        var left: Node<K, V>?,
        var right: Node<K, V>?
    )

    override fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    override fun isEmpty() = size() == 0

    override fun get(k: K) = get(root, k)

    private fun get(node: Node<K, V>?, k: K): V? =
        when {
            node == null -> null
            node.key == k -> node.value
            node.key > k -> get(node.left, k)
            else -> get(node.right, k)
        }

    override fun contains(k: K) = get(k) != null

    override fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, key: K, value: V): Node<K, V> {
        when {
            node == null -> return Node(key, value, 0, null, null)
            node.key == key -> node.value = value
            node.key > key -> node.left = put(node.left, key, value)
            else -> node.right = put(node.right, key, value)
        }
        node.size = size(node.right) + size(node.left) + 1
        return node
    }

    override fun min() = root?.let { min(it) }

    private fun min(node: Node<K, V>): Node<K, V> {
        if (node.left == null)
            return node
        return min(node.left!!)
    }

    override fun max(): Node<K, V>? {
        if (root == null)
            return null
        return max(root!!)
    }

    private fun max(node: Node<K, V>): Node<K, V> {
        if (node.right == null)
            return node
        return max(node.right!!)
    }

    override fun floor(k: K) = floor(root, k)?.key

    private fun floor(node: Node<K, V>?, k: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key > k -> floor(node.left, k)
            else -> {
                val aux = floor(node.right, k)
                aux ?: node
            }
        }

    override fun ceiling(k: K) = ceiling(root, k)?.key

    private fun ceiling(node: Node<K, V>?, k: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key < k -> ceiling(node.right, k)
            else -> {
                val aux = ceiling(node.left, k)
                aux ?: node
            }
        }

    override fun select(rank: Int) = select(root, rank)

    private fun select(node: Node<K, V>?, rank: Int): K? =
        when {
            node == null -> null
            size(node.left) > rank -> select(node.left, rank)
            size(node.left) < rank -> select(node.right, rank - size(node.left) - 1)
            else -> node.key
        }

    override fun rank(k: K) = rank(root, k)

    private fun rank(node: Node<K, V>?, k: K): Int =
        when {
            node == null -> 0
            node.key > k -> rank(node.left, k)
            node.key < k -> size(node.left) + 1 + rank(node.right, k)
            else -> size(node.left)
        }

    override fun deleteMin() {
        if (root != null) {
            root = deleteMin(root!!)
        }
    }

    private fun deleteMin(node: Node<K, V>): Node<K, V>? {
        if (node.left == null) {
            return node.right
        }
        node.left = deleteMin(node.left!!)
        node.size = size(node.left) + size(node.right) + 1
        return node
    }

    override fun deleteMax() {
        if (root != null) {
            root = deleteMax(root!!)
        }
    }

    private fun deleteMax(node: Node<K, V>): Node<K, V>? {
        if (node.right == null) {
            return node.left
        }
        node.right = deleteMax(node.right!!)
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    override fun delete(k: K) {
        if (root != null) {
            root = delete(root, k)
        }
    }

    private fun delete(node: Node<K, V>?, k: K): Node<K, V>? {
        var nodec: Node<K, V>? = node
        when {
            node == null -> return null
            node.key > k -> node.left = delete(node.left, k)
            node.key < k -> node.right = delete(node.right, k)
            else -> {
                nodec = if (node.right != null) min(node.right!!) else null
                nodec?.right = if (node.right != null) deleteMin(node.right!!) else null
                nodec?.left = node.left
            }
        }
        nodec?.size = size(nodec?.right) + size(nodec?.left) + 1
        return nodec
    }

    override fun printAll() {
        print(root)
    }

    private fun print(node: Node<K, V>?) {
        if (node == null) {
            return
        }
        print(node.left)
        print(node.value)
        print(node.right)
    }

    override fun keys(): Iterable<Node<K, V>>? {
        val min = min()
        val max = max()
        if (min != null && max != null) {
            return keys(min.key, max.key)
        }
        return null
    }

    override fun keys(l: K, h: K): Iterable<Node<K, V>>? {
        val queue = Queue<Node<K, V>>()
        keys(root, queue, l, h)
        return queue
    }

    private fun keys(node: Node<K, V>?, queue: Queue<Node<K, V>>, l: K, h: K) {
        if (node == null) return
        if (node.key > l) keys(node.left, queue, l, h)
        if (node.key in l..h) queue.enqueue(node)
        if (node.key < h) keys(node.right, queue, l, h)
    }
}

fun main() {
    val a = BST<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    println(a.get(4))
    println(a.get(3))
    println(a.get(1))
    println(a.floor(2))
    println(a.floor(7))
    println(a.ceiling(7))
    println(a.ceiling(2))
    println(a.select(0))
    a.deleteMax()
    println(a.get(3))
    println(a.get(4))
    a.put(8, "7")
    a.put(9, "0")
    println(a.get(9))
    a.delete(9)
    println(a.get(9))
    println("----------")
    a.printAll()
    println()
    for (e in a.keys()!!)
        println(e)

}