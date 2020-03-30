package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag
import jalg.chapter4.Graph

class Exercise3(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0

    constructor(graph: Graph) : this(graph.size) {
        e = graph.e()
        for (i in 0 until graph.size) {
            for (e in graph.adj(i)) {
                adj[i].add(e)
            }
        }
    }

    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]
}

fun main() {
    val g = Graph(4)
    g.addEdge(1, 2)
    g.addEdge(2, 3)
    g.addEdge(1, 3)
    val a = Exercise3(g)
    a.adj(3).forEach { println(it) }
}