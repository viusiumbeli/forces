package jalg.answers.chapter3.section3

import jalg.chapter3.RedBlackST

class Exercise33<K : Comparable<K>, V> : RedBlackST<K, V>() {
    fun is23() = is23(root)

    private fun is23(node: Node<K, V>?): Boolean =
        when {
            node == null -> true
            isRed(node.left) && isRed(node.right) -> false
            isRed(node.right) -> false
            else -> is23(node.left) && is23(node.right)
        }

    fun isBalanced() = isBalanced(root, 0)

    private fun isBalanced(node: Node<K, V>?, black: Int): Boolean {
        if (node == null) {
            return true
        }
        val aux = if (isRed(node)) 1 else 0
        return isBalanced(node.left, black + aux) && isBalanced(node.right, black + aux)

    }
}

fun main() {
    val a = Exercise33<Int, Int>()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    a.put(6, 6)
    a.put(7, 7)
    a.put(8,8)
    println(a.is23())
    print(a.isBalanced())
}
