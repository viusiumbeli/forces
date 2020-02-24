package jalg.answers.chapter1.section3

fun main() {
    val first = Stack.Node(0)
    val n1 = Stack.Node(1)
    val n2 = Stack.Node(4)
    val n3 = Stack.Node(3)
    first.next = n1
    n1.next = n2
    n2.next = n3
    println(max(first))
}

fun max(first: Stack.Node<Int>): Int {
    var max = 0
    var cur: Stack.Node<Int>? = first
    while (cur != null) {
        if (cur.item > max) {
            max = cur.item
        }
        cur = cur.next
    }

    return max
}
