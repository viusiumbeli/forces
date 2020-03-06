package jalg.answers.chapter2.section4

class Exercise2List<T : Comparable<T>> {
    var first: Node<T>? = null

    infix fun insert(key: T) {
        val newNode = Node(key)
        if (first == null) {
            first = newNode
        } else {
            newNode.next = first
            first = newNode
        }
    }

    fun max(): T {
        if (first == null)
            throw NoSuchElementException()

        if (first!!.next == null) {
            val item = first!!.item
            first = null
            return item
        }

        var prevMax = first
        var curr = first
        while (curr!!.next != null) {
            if (prevMax!!.next!!.item < curr.next!!.item)
                prevMax = curr
            curr = curr.next
        }

        if (first!!.item > prevMax!!.next!!.item) {
            val item = first!!.item
            first = first!!.next
            return item
        }

        val item = prevMax.next!!.item
        prevMax.next = prevMax.next!!.next
        return item
    }

    data class Node<T>(val item: T) {
        var next: Node<T>? = null
    }

}

fun main() {
    val a = Exercise2List<Int>()
    a insert 3
    a insert 2
    a insert 1
    a insert 1
    a insert 2
    a insert 8
    a insert 4
    a insert 7
    a insert 6
    for (i in 0 until 9)
        println(a.max())
}