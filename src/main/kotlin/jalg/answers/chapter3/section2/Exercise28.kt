package jalg.answers.chapter3.section2

class Exercise28<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var size: Int, var left: Node<K, V>?, var right: Node<K, V>?)

    var root: Node<K, V>? = null
    var recentlyUsed: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun put(k: K, v: V) {
        if (recentlyUsed?.key == k)
            recentlyUsed!!.value = v
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V>? {
        when {
            node == null -> {
                recentlyUsed = Node(k, v, 0, null, null)
                return recentlyUsed
            }
            node.key > k -> node.left = put(node.left, k, v)
            node.key < k -> node.right = put(node.right, k, v)
            else -> {
                recentlyUsed = node
                node.value = v
            }
        }
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    fun get(k: K): V? {
        if (recentlyUsed?.key == k) {
            return recentlyUsed!!.value
        }
        return get(root, k)?.value
    }

    private fun get(node: Node<K, V>?, k: K): Node<K, V>? =
        when {
            node == null -> null
            node.key == k -> {
                recentlyUsed = node
                node
            }
            node.key > k -> get(node.left, k)
            else -> get(node.right, k)
        }

}

fun main() {
    val a = Exercise28<Int, String>()
    a.put(1,"2")
    a.put(3,"4")
    a.put(5,"6")
    println(a.get(5))
    println(a.get(4))
    println(a.get(3))
    println(a.get(1))
}