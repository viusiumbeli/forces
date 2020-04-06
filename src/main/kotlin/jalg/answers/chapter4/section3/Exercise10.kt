package jalg.answers.chapter4.section3

import java.util.*

class Exercise10(private val size: Int) {
    private val adjacency = Array(size) { IntArray(size) { -1 } }
    private var edges = 0

    fun edgeCount() = edges
    fun vertices() = size
    fun addEdge(v: Int, w: Int, weight: Int) {
        adjacency[v][w] = weight
        adjacency[w][v] = weight
        edges++
    }

    fun weight(v: Int, w: Int) = adjacency[v][w]

    fun adj(v: Int): Iterable<Int> {
        val adj = LinkedList<Int>()
        for (i in 0 until vertices()) {
            if (adjacency[v][i] != -1) {
                adj.push(i)
            }
        }
        return adj
    }

    fun edjes(): LinkedList<Int> {
        val edj = LinkedList<Int>()
        for (i in 0 until vertices()) {
            edj.addAll(adj(i))
        }
        return edj
    }
}

fun main() {
    val a = Exercise10(3)
    a.addEdge(0, 1, 2)
    a.addEdge(1, 2, 3)
    a.addEdge(2, 0, 1)
    println(a.weight(2, 1))
}