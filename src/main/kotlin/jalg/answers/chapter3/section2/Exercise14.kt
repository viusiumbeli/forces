package jalg.answers.chapter3.section2

class Exercise14<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var size: Int, var left: Node<K, V>?, var right: Node<K, V>?)

    private var root: Node<K, V>? = null

    fun size(node: Node<K, V>?) = node?.size ?: 0

    fun get(k: K): V? {
        var cp = root
        while (cp != null && cp.key != k)
            cp = if (cp.key < k) cp.right else cp.left
        return cp?.value
    }

    fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V>? {
        when {
            node == null -> return Node(k, v, 0, null, null)
            node.key == k -> node.value = v
            node.key < k -> node.right = put(node.right, k, v)
            else -> node.left = put(node.left, k, v)
        }
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    fun min(): Node<K, V>? {
        if (root == null) {
            return null
        }
        var cp = root!!
        while (cp.left != null)
            cp = cp.left!!
        return cp
    }

    fun max(): Node<K, V>? {
        if (root == null)
            return null
        var cp = root!!
        while (cp.right != null)
            cp = cp.right!!
        return cp
    }

    fun floor(k: K): K? {
        var cp = root
        var floor: Node<K, V>? = null
        while (cp != null) {
            if (cp.key == k) {
                floor = cp
                break
            }
            when {
                cp.key > k -> cp = cp.left
                cp.key < k -> {
                    floor = cp
                    cp = cp.right
                }
            }
        }
        return floor?.key
    }

    fun rank(k: K): Int {
        var rank = 0
        var cp = root
        while (cp != null) {
            if (cp.key == k) {
                rank += size(cp.left) + 1
                break
            }
            when {
                cp.key > k -> cp = cp.left
                else -> {
                    rank += size(cp.left) + 1
                    cp = cp.right
                }
            }
        }
        return if (cp == null) 0 else rank
    }
}

fun main() {
    val a = Exercise14<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    a.put(5, "7")
    println(a.get(4))
    println(a.get(3))
    println(a.get(5))
    println(a.min())
    println(a.max())
    println(a.floor(7))
    println(a.floor(4))
    println(a.floor(2))
    println(a.rank(3))
    println(a.rank(5))
}