package jalg.answers.chapter4.section2

import edu.princeton.cs.algs4.Bag

class Exercise5(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var edges = 0

    fun vertices() = size

    fun edges() = edges

    fun addEdge(v: Int, w: Int) {
        if (isSelfCycle(v, w)) return
        if (isParallelEdge(v, w)) return
        if (isParallelEdge(w, v)) return
        adj[v].add(w)
        edges++
    }

    private fun isParallelEdge(v: Int, w: Int): Boolean {
        for (e in adj(w)) {
            if (v == e) {
                return true
            }
        }
        return false
    }

    private fun isSelfCycle(v: Int, w: Int) = v == w

    fun adj(v: Int) = adj[v]

}

fun main() {
    val a = Exercise5(4)
    a.addEdge(0, 1)
    a.addEdge(1, 2)
    a.addEdge(2, 3)
    a.addEdge(3, 0)
    println(a.edges())
    a.addEdge(3, 0)
    a.addEdge(3, 3)
    println(a.edges())
}