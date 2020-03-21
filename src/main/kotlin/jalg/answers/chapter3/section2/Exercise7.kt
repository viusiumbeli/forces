package jalg.answers.chapter3.section2

class Exercise7<K : Comparable<K>, V> {
    class Node<K, V>(val key: K, var value: V, var size: Int, var left: Node<K, V>?, var right: Node<K, V>?)

    var root: Node<K, V>? = null

    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.size ?: 0

    fun put(k: K, v: V) {
        root = put(root, k, v)
    }

    private fun put(node: Node<K, V>?, k: K, v: V): Node<K, V> {
        when {
            node == null -> return Node(k, v, 0, null, null)
            node.key == k -> node.value = v
            node.key > k -> node.left = put(node.left, k, v)
            else -> node.right = put(node.right, k, v)
        }
        node.size = size(node.left) + 1 + size(node.right)
        return node
    }

    fun avgCompares(): Double {
        val avgCompares = avgCompares(root)

        return avgCompares.toDouble() / size() + 1
    }

    private fun avgCompares(node: Node<K, V>?): Int {
        if (node == null) {
            return 0
        }
        return avgCompares(node.left) + 1 + avgCompares(node.right) + 1
    }
}

fun main() {
    val a = Exercise7<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    a.put(2, "7")
    println(a.avgCompares())
}