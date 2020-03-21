package jalg.answers.chapter3.section2

class Exercise30<K : Comparable<K>, V> {
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

    fun isOrdered(min: K, max: K) = isOrdered(root, min, max)

    private fun isOrdered(node: Node<K, V>?, min: K, max: K): Boolean =
        if (node == null)
            true
        else {
            val leftOrdered = if (node.left != null)
                node.left!!.key < node.key
            else true
            val rightOrdered = if (node.right != null)
                node.right!!.key > node.key
            else
                true
            node.key in min..max && leftOrdered && rightOrdered &&
                    isOrdered(node.left, min, max) && isOrdered(node.right, min, max)
        }
}

fun main() {
    val a = Exercise30<Int, String>()
    a.put(1, "2")
    a.put(3, "4")
    a.put(5, "6")
    println(a.get(5))
    println(a.get(4))
    println(a.get(3))
    println(a.get(1))
    println(a.isOrdered(0, 6))
}