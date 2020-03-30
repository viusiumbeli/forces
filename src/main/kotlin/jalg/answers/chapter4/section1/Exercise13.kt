package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag
import java.util.*

class Exercise13(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0
    private val distTo = IntArray(size) { Int.MAX_VALUE }
    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]

    fun distTo(vertex: Int): Int {
        val queue = LinkedList<Int>()
        queue.push(1)
        distTo[1] = 0
        while (queue.isNotEmpty()) {
            val w = queue.pop()
            for (v in adj(w)) {
                if (distTo[w] + 1 < distTo[v]) {
                    distTo[v] = distTo[w] + 1
                    queue.push(v)
                }
            }
        }
        return distTo[vertex]
    }
}

fun main() {
    val a = Exercise13(4)
    a.addEdge(1, 2)
    a.addEdge(1, 3)
    a.addEdge(2, 3)
    println(a.distTo(2))
    println(a.distTo(3))
}