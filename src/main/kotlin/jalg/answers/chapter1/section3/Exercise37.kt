package jalg.answers.chapter1.section3

import edu.princeton.cs.algs4.Queue

fun main() {
    val queue = Queue<Int>()
    val n = 7
    val m = 2
    for (i in 0 until n)
        queue.enqueue(i)

    var i = 0
    while (!queue.isEmpty) {
        val item = queue.dequeue()
        if (i % m - 1 == 0)
            println(item)
        else
            queue.enqueue(item)
        i++
    }

}