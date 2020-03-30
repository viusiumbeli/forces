package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag

class Exercise5(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0

    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        if (v != w && !hasEdge(v, w)) {
            adj[v].add(w)
            adj[w].add(v)
            e++
        }
    }

    fun hasEdge(v: Int, w: Int): Boolean {
        for (e in adj(w))
            if (e == v) {
                return true
            }
        return false
    }

    fun adj(v: Int) = adj[v]
}

fun main() {
    val a = Exercise4(4)
    a.addEdge(1, 2)
    a.addEdge(1, 3)
    a.addEdge(2, 3)

}