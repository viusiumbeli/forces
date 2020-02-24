package jalg.answers.chapter1.section3

fun main() {
    val first = Stack.Node(0)
    val n1 = Stack.Node(1)
    val n2 = Stack.Node(5)
    val n3 = Stack.Node(6)
    first.next = n1
    n1.next = n2
    n2.next = n3
    val copy = null
    var reverse = reverser(first)
    while (reverse != null) {
        println(reverse.item)
        reverse = reverse.next
    }
}

fun reverse(first: Stack.Node<Int>?): Stack.Node<Int>? {
    var copy: Stack.Node<Int>? = null
    var cur = first
    while (cur != null) {
        val tmp = cur.next
        cur.next = copy
        copy = cur
        cur = tmp
    }
    return copy
}

fun reverser(first: Stack.Node<Int>?): Stack.Node<Int>? {
    if (first == null) {
        return null
    }

    if(first.next ==null){
        return first
    }

    val tmp = first.next
    val rest = reverser(tmp)
    rest!!.next = first
    first.next = null
    return rest
}
