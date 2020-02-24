package jalg.answers.chapter1.section3

import edu.princeton.cs.algs4.Queue

fun main() {
    val q = Queue<Int>()
    q.enqueue(0)
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)

    val copy = copyQueue(q)
    q.enqueue(4)
    copy.enqueue(5)

    q.forEach { println(it) }
    copy.forEach { println(it) }
}

fun copyQueue(q: Queue<Int>): Queue<Int> {
    val copy = Queue<Int>()
    val size = q.size()
    for (i in 0 until size) {
        val item = q.dequeue()
        copy.enqueue(item)
        q.enqueue(item)
    }
    return copy
}
