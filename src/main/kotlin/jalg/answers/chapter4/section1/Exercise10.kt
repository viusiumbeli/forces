package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag

class Exercise10(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0
    private val marked = BooleanArray(size) { false }

    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]

    fun redundant() = redundant(1)

    private fun redundant(v: Int): Int {
        marked[v] = true
        for (e in adj(v)) {
            if (!marked[e]) {
                return redundant(e)
            }
        }
        return v
    }
}

fun main() {
    val a = Exercise10(4)
    a.addEdge(1, 3)
    a.addEdge(1, 2)
    a.addEdge(2, 3)
    println(a.redundant())
}