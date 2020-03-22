package jalg.answers.chapter3.section3

class Exercise23<K : Comparable<K>, V> {
    data class Node<K, V>(
        val key: K,
        var value: V,
        var size: Int,
        var left: DoubleNode<K, V>?,
        var right: DoubleNode<K, V>?
    )

    data class DoubleNode<K, V>(
        var left: Node<K, V>?,
        var right: Node<K, V>?
    )

    private var root: DoubleNode<K, V>? = null

    fun size() = size(root)

    private fun size(node: DoubleNode<K, V>?) = node?.left?.size ?: 0 + (node?.right?.size ?: 0)

    private fun isEmpty() = size() == 0

    fun put(key: K, value: V) {
        root = put(root, key, value)
    }

    private fun put(node: DoubleNode<K, V>?, key: K, value: V): DoubleNode<K, V> {
        if (node == null) {
            return DoubleNode(Node(key, value, 0, null, null), null)
        }

        if (node.left != null) {
            if (node.left!!.key < key) {
                if (node.right == null) {
                    node.right = Node(key, value, 0, null, null)
                } else {
                    if (node.left!!.key < key && node.right!!.key > key) {
                        node.left!!.right = put(node.left!!.right, key, value)
                    } else {
                        node.right!!.right = put(node.right!!.right, key, value)
                    }
                }
            } else {
                if (node.left != null) {
                    node.left!!.left = put(node.left!!.left, key, value)
                } else {
                    node.right = Node(key, value, 0, null, null)
                }
            }
        } else {
            node.left = Node(key, value, 0, null, null)
        }

        node.left!!.size = size(node.left?.left) + 1 + size(node.right?.right)
        node.right?.size = size(node.right?.right) + 1
        return node
    }

    fun get(key: K): V? {
        return get(root, key)?.value
    }

    private fun get(node: DoubleNode<K, V>?, key: K): Node<K, V>? {
        if (node == null) {
            return null
        }

        if (node.left?.key == key) {
            return node.left
        }

        if (node.right?.key == key) {
            return node.right
        }

        if (node.left?.key != null && node.left!!.key > key) {
            return get(node.left!!.left, key)
        }
        if (node.left != null && node.left!!.key > key && node.right!!.key < key) {
            return get(node.left?.right, key)
        }
        if (node.right != null) {
            return get(node.right!!.right, key)
        }
        return null
    }

    fun min(): K? {
        if (root == null) {
            return null
        }
        return min(root!!)?.key
    }

    private fun min(node: DoubleNode<K, V>): Node<K, V>? {
        if (node.left?.left == null) {
            return node.left
        }
        return min(node.left!!.left!!)
    }

    fun max(): K? {
        if (root == null) {
            return null
        }
        return max(root!!)?.key
    }

    private fun max(node: DoubleNode<K, V>?): Node<K, V>? {
        if (node?.right?.right == null) {
            return node?.right
        }
        return max(node.right!!.right!!)
    }
}

fun main() {
    val a = Exercise23<Int, Int>()
    a.put(2, 2)
    a.put(1, 1)
    a.put(4, 4)
    a.put(3, 3)
    a.put(6, 6)
    a.put(5, 5)
    a.put(8, 8)
    a.put(7, 7)
    println(a.get(0) ?: -1)
    println(a.min())
    println(a.max())
}