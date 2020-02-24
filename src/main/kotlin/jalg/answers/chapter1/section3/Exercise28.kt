package jalg.answers.chapter1.section3

fun main() {
    val first = Stack.Node(0)
    val n1 = Stack.Node(1)
    val n2 = Stack.Node(5)
    val n3 = Stack.Node(6)
    first.next = n1
    n1.next = n2
    n2.next = n3
    println(maxr(first, 0))
}

fun maxr(first: Stack.Node<Int>?, max: Int): Int =
    if (first == null) {
        max
    } else {
        maxr(first.next, max.coerceAtLeast(first.item))
    }
