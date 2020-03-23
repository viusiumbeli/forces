package jalg.chapter3

import edu.princeton.cs.algs4.RedBlackBST
import kotlin.math.max

class AVLTree<K : Comparable<K>, V> {
    data class Node<K, V>(
        val key: K,
        var value: V,
        var height: Int,
        var size: Int,
        var left: Node<K, V>?,
        var right: Node<K, V>?
    )

    private var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun height() = height(root)

    private fun height(node: Node<K, V>?) = node?.height ?: 0

    private fun bfactor(node: Node<K, V>?) = height(node?.left) - height(node?.right)

    fun get(key: K) = get(root, key)?.value

    private fun get(node: Node<K, V>?, key: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == key -> node
            node.key > key -> get(node.left, key)
            else -> get(node.right, key)
        }

    fun put(key: K, value: V) {
        root = put(root, key, value)
    }

    private fun put(node: Node<K, V>?, key: K, value: V): Node<K, V>? {
        when {
            node == null -> return Node(key, value, 1, 0, null, null)
            node.key == key -> node.value = value
            node.key > key -> node.left = put(node.left, key, value)
            else -> node.right = put(node.right, key, value)
        }
        return balance(node)
    }

    private fun balance(node: Node<K, V>?): Node<K, V>? {
        if (node == null) {
            return null
        }
        fixHeight(node)
        fixSize(node)
        return when (bfactor(node)) {
            -2 -> {
                if (bfactor(node.right) > 0)
                    node.right = rotateRight(node.right!!)
                rotateLeft(node)
            }
            2 -> {
                if (bfactor(node.left) < 0)
                    node.left = rotateLeft(node.left!!)
                rotateRight(node)
            }
            else -> node
        }
    }

    private fun rotateLeft(node: Node<K, V>): Node<K, V>? {
        val aux = node.right!!
        node.right = aux.left
        aux.left = node
        aux.size = node.size
        fixSize(node)
        fixHeight(node)
        fixHeight(aux)
        return aux
    }

    private fun rotateRight(node: Node<K, V>): Node<K, V>? {
        val aux = node.left!!
        node.left = aux.right
        aux.right = node
        aux.size = node.size
        fixSize(node)
        fixHeight(node)
        fixHeight(aux)
        return aux
    }

    private fun fixHeight(node: Node<K, V>) {
        node.height = max(height(node.left), height(node.right)) + 1
    }

    private fun fixSize(node: Node<K, V>) {
        node.size = size(node.left) + 1 + size(node.right)
    }

    fun min(): K? =
        when (root) {
            null -> null
            else -> min(root!!)?.key
        }

    private fun min(node: Node<K, V>): Node<K, V>? =
        when (node.left) {
            null -> node
            else -> min(node.left!!)
        }

    fun max(): K? =
        when (root) {
            null -> null
            else -> max(root!!)?.key
        }

    private fun max(node: Node<K, V>): Node<K, V>? =
        when (node.right) {
            null -> node
            else -> max(node.right!!)
        }

    fun deleteMin() {
        if (root != null) {
            root = deleteMin(root!!)
        }
    }

    private fun deleteMin(node: Node<K, V>): Node<K, V>? {
        when (node.left) {
            null -> return node.right
            else -> node.left = deleteMin(node.left!!)
        }
        return balance(node)
    }

    fun deleteMax() {
        if (root == null) {
            root = deleteMax(root!!)
        }
    }

    private fun deleteMax(node: Node<K, V>): Node<K, V>? {
        when (node.right) {
            null -> return node.left
            else -> node.right = deleteMax(node.right!!)
        }
        return balance(node)
    }

    fun delete(key: K) {
        root = delete(root, key)
    }

    private fun delete(node: Node<K, V>?, key: K): Node<K, V>? {
        when {
            node == null -> return null
            node.key > key -> node.left = delete(node.left, key)
            node.key < key -> node.right = delete(node.right, key)
            else -> {
                if (node.right != null) {
                    val min = min(node.right!!)!!
                    min.right = deleteMin(node.right!!)
                    min.left = node.left
                    return balance(min)
                }
                return balance(node.left)
            }
        }
        return balance(node)
    }

    fun select(rank: Int): K? = select(root, rank)?.key

    private fun select(node: Node<K, V>?, rank: Int): Node<K, V>? =
        when {
            node == null -> null
            size(node) == rank -> node
            size(node.left) > rank -> select(node.left, rank)
            else -> select(node.right, rank - 1 - size(node.left))
        }

    fun rank(key: K): Int {
        return rank(root, key)
    }

    private fun rank(node: Node<K, V>?, key: K): Int =
        when {
            node == null -> 0
            node.key > key -> rank(node.left, key)
            node.key < key -> rank(node.right, key) + 1 + size(node.left)
            else -> size(node.left) + 1
        }
}

fun main() {
    val a = AVLTree<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
    println(a.get(3))
    println(a.min())
    println(a.max())
    a.delete(3)
    println(a.get(3))
    a.delete(4)
    println(a.get(4))
    println(a.rank(4))
    println(a.rank(5))
    val b = RedBlackBST<Int, Int>()
    b.put(4, 4)
    b.put(5, 5)
    b.put(3, 3)
    println(b.rank(7))
}