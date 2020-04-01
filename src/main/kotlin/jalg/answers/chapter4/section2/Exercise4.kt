package jalg.answers.chapter4.section2

import edu.princeton.cs.algs4.Bag

class Exercise4(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var edges = 0

    fun vertices() = size

    fun edges() = edges

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        edges++
    }

    fun adj(v: Int) = adj[v]

    fun hasEdge(v: Int, w: Int): Boolean {
        for (e in adj(v)) {
            if (e == w) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val a = Exercise4(4)
    a.addEdge(0, 1)
    a.addEdge(1, 2)
    a.addEdge(2, 3)
    a.addEdge(3, 0)
    println(a.hasEdge(3, 0))
    println(a.hasEdge(3, 1))
}