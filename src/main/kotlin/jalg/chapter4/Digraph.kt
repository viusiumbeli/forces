package jalg.chapter4

import edu.princeton.cs.algs4.Bag

class Digraph(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var edges = 0

    fun vertices() = size

    fun edges() = edges

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        edges++
    }

    fun adj(v: Int) = adj[v]
}