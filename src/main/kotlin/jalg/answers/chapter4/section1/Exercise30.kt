package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag

class Exercise30(val size: Int) {
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

    fun parallelEdges(): Int {
        var parallels = 0
        val visited = BooleanArray(size) { false }
        for (v in adj.indices) {
            for (e in adj(v)) {
                if (visited[e]) {
                    parallels++
                }
                visited[e] = true
            }
            for (e in adj(v))
                visited[e] = false
        }
        return parallels / 2
    }

}

fun main() {
    val a = Exercise30(4)
    a.addEdge(1, 2)
    a.addEdge(2, 1)
    a.addEdge(1, 3)
    a.addEdge(2, 3)
    println(a.parallelEdges())
}