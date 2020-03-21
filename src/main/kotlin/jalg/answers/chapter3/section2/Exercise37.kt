package jalg.answers.chapter3.section2

import jalg.chapter3.BST
import java.util.*


fun main() {
    val a = BST<Int, String>()
    a.put(10, "Value 10")
    a.put(4, "Value 4")
    a.put(6, "Value 6")
    a.put(1, "Value 1")
    a.put(2, "Value 2")
    a.put(15, "Value 15")
    a.put(12, "Value 12")
    a.put(20, "Value 20")
    a.put(25, "Value 25")
    printLevel(a.root)
}

private fun printLevel(node: BST.Node<Int, String>?) {
    val queue = LinkedList<BST.Node<Int, String>>()
    queue.push(node)
    while (queue.isNotEmpty()) {
        val pop = queue.poll()
        println(pop.key)
        if (pop.left != null) {
            queue.add(pop.left!!)
        }
        if (pop.right != null) {
            queue.add(pop.right!!)
        }
    }
}