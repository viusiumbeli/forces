package jalg.answers.chapter4.section2

import edu.princeton.cs.algs4.Bag
import jalg.chapter4.Digraph
import java.util.*

class Exercise3(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var edges = 0

    constructor(digraph: Digraph) : this(digraph.vertices()) {
        for (i in 0 until size) {
            val ver = LinkedList<Int>()
            for (e in digraph.adj(i)) {
                ver.push(e)
            }
            for (j in ver.indices) {
                addEdge(i, ver.pop())
            }
        }
    }

    fun vertices() = size

    fun edges() = edges

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        edges++
    }

    fun adj(v: Int) = adj[v]
}

fun main() {
    val digraph = Digraph(4)
    digraph.addEdge(0, 1)
    digraph.addEdge(1, 2)
    digraph.addEdge(2, 3)
    digraph.addEdge(3, 4)
    val a = Exercise3(digraph)
    println(a.edges())
    println(digraph.edges())
    digraph.addEdge(1, 4)
    println(a.edges())
    println(digraph.edges())
}