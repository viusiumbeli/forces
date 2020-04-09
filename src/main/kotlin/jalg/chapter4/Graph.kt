package jalg.chapter4

import edu.princeton.cs.algs4.Bag

class Graph(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0

    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]
}