package jalg.answers.chapter3.section2

import edu.princeton.cs.algs4.Queue
import jalg.chapter3.BST
import jalg.chapter3.SearchTree

class Exercise6_1<K : Comparable<K>, V> : SearchTree<K, V> {
    private var root: BST.Node<K, V>? = null

    override fun size() = size(root)

    private fun size(node: BST.Node<K, V>?) = node?.size ?: 0

    override fun isEmpty() = size(root) == 0

    override fun get(k: K): V? = get(root, k)

    private fun get(node: BST.Node<K, V>?, k: K): V? =
        when {
            node == null -> null
            node.key == k -> node.value
            node.key < k -> get(node.right, k)
            else -> get(node.left, k)
        }

    override fun contains(k: K) = get(k) == null

    override fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: BST.Node<K, V>?, k: K, v: V): BST.Node<K, V>? {
        when {
            node == null -> return BST.Node(k, v, 0, null, null)
            node.key == k -> node.value = v
            node.key < k -> node.right = put(node.right, k, v)
            else -> node.left = put(node.left, k, v)
        }
        node.size = size(node.left) + size(node.right) + 1
        return node
    }

    override fun min(): BST.Node<K, V>? {
        if (root == null) {
            return null
        }
        return min(root!!)
    }

    private fun min(node: BST.Node<K, V>): BST.Node<K, V> {
        if (node.left == null) {
            return node
        }
        return min(node.left!!)
    }

    override fun max(): BST.Node<K, V>? {
        if (root == null) {
            return null
        }
        return max(root!!)
    }

    private fun max(node: BST.Node<K, V>): BST.Node<K, V> {
        if (node.right == null) {
            return node
        }
        return max(node.right!!)
    }

    override fun floor(k: K) = floor(root, k)?.key

    private fun floor(node: BST.Node<K, V>?, k: K): BST.Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key > k -> floor(node.left, k)
            else -> floor(node.right, k) ?: node
        }

    override fun ceiling(k: K): K? = ceiling(root, k)?.key

    private fun ceiling(node: BST.Node<K, V>?, k: K): BST.Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key < k -> ceiling(node.right, k)
            else -> ceiling(node.left, k) ?: node
        }

    override fun select(rank: Int): K? = select(root, rank)?.key

    private fun select(node: BST.Node<K, V>?, rank: Int): BST.Node<K, V>? =
        when {
            node == null -> null
            size(node.left) == rank -> node
            size(node.left) > rank -> select(node.left, rank)
            else -> select(node.right, rank - 1 - size(node.left))
        }

    override fun rank(k: K): Int {
        return rank(root, k)
    }

    private fun rank(node: BST.Node<K, V>?, k: K): Int =
        when {
            node == null -> 0
            node.key == k -> size(node.left)
            node.key > k -> rank(node.left, k)
            else -> rank(node.right, k) + 1 + size(node.left)
        }

    override fun deleteMin() {
        if (root != null) {
            root = deleteMin(root!!)
        }
    }

    private fun deleteMin(node: BST.Node<K, V>): BST.Node<K, V>? {
        if (node.left == null)
            return node.right
        node.left = deleteMin(node.left!!)
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    override fun deleteMax() {
        if (root != null)
            root = deleteMax(root!!)
    }

    private fun deleteMax(node: BST.Node<K, V>): BST.Node<K, V>? {
        if (node.right == null) {
            return node.left
        }
        node.right = deleteMax(node.right!!)
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    override fun delete(k: K) {
        root = delete(root, k)
    }

    private fun delete(node: BST.Node<K, V>?, k: K): BST.Node<K, V>? {
        var min: BST.Node<K, V>? = node
        when {
            node == null -> return null
            node.key > k -> node.left = delete(node.left, k)
            node.key < k -> node.right = delete(node.right, k)
            else -> {
                min = if (node.right != null) min(node.right!!) else null
                min?.right = if (node.right != null) deleteMin(node.right!!) else null
                min?.left = node.left
            }

        }
        min?.size = size(node.left) + 1 + size(node.right)
        return min
    }

    override fun printAll() {
        print(root)
    }

    private fun print(node: BST.Node<K, V>?) {
        if (node == null) {
            return
        }
        print(node.left)
        print(node.key)
        print(node.right)
    }

    override fun keys(): Iterable<BST.Node<K, V>>? {
        val min = min()
        val max = max()
        if (min != null && max != null) {
            return keys(min.key, max.key)
        }
        return null
    }

    override fun keys(l: K, h: K): Iterable<BST.Node<K, V>>? {
        val queue = Queue<BST.Node<K, V>>()
        keys(queue, root, l, h)
        return queue
    }

    private fun keys(queue: Queue<BST.Node<K, V>>, node: BST.Node<K, V>?, l: K, h: K) {
        if (node == null) return
        if (node.key > l) keys(queue, node.left, l, h)
        if (node.key in l..h) queue.enqueue(node)
        if (node.key < h) keys(queue, node.right, l, h)
    }

    fun height(): Int {
        return height(root)
    }

    private fun height(node: BST.Node<K, V>?): Int {
        if (node == null) {
            return 0
        }
        return kotlin.math.max(height(node.left) + 1, height(node.right) + 1)
    }
}

fun main() {
    val a = Exercise6_1<Int, String>()
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
    a.put(2, "0")
    a.put(1, "0")

    println(a.height())
}