package jalg.answers.chapter3.section2

import edu.princeton.cs.algs4.Queue

class Exercise33<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var size: Int, var left: Node<K, V>?, var right: Node<K, V>?)

    var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V>? {
        when {
            node == null -> return Node(k, v, 1, null, null)
            node.key > k -> node.left = put(node.left, k, v)
            node.key < k -> node.right = put(node.right, k, v)
            else -> node.value = v
        }
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    fun get(k: K) = get(root, k)?.value

    private fun get(node: Node<K, V>?, k: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> node
            node.key > k -> get(node.left, k)
            else -> get(node.right, k)
        }

    fun rank(k: K) = rank(root, k)

    private fun rank(node: Node<K, V>?, k: K): Int =
        when {
            node == null -> 0
            node.key == k -> size(node.left)
            node.key > k -> rank(node.left, k)
            else -> size(node.left) + 1 + rank(node.right, k)
        }

    fun select(rank: Int) = select(root, rank)

    private fun select(node: Node<K, V>?, rank: Int): K? {
        val t = size(node?.left)
        return when {
            node == null -> null
            t > rank -> select(node.left, rank)
            t < rank -> select(node.right, rank - t - 1)
            else -> node.key
        }
    }

    fun rankSelectCheck(): Boolean {
        for (i in 0 until size())
            if (i != rank(select(i) ?: return false))
                return false

        for (k in keys())
            if (k.key != select(rank(k.key)))
                return false
        return true
    }

    fun keys(): Queue<Node<K, V>> {
        val queue = Queue<Node<K, V>>()
        keys(root, queue)
        return queue
    }

    private fun keys(node: Node<K, V>?, queue: Queue<Node<K, V>>) {
        if (node == null) return
        keys(node.left, queue)
        queue.enqueue(node)
        keys(node.right, queue)
    }
}

fun main() {
    val a = Exercise33<Int, String>()
    a.put(1, "2")
    a.put(3, "4")
    a.put(5, "6")
    println(a.get(5))
    println(a.get(4))
    println(a.get(3))
    println(a.get(1))
    println(a.rankSelectCheck())
}