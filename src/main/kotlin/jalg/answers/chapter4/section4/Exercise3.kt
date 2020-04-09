package jalg.answers.chapter4.section4

import jalg.chapter4.Edge
import java.util.*

class Exercise3(val size: Int) {
    private val EMPTY_EDGE = -1
    private val data = Array(size) { IntArray(size) { EMPTY_EDGE } }
    private val vertices = size
    private var edges = 0

    fun addEdge(v: Int, w: Int, weight: Int) {
        data[v][w] = weight
        edges++
    }

    fun hasEdge(v: Int, w: Int) = data[v][w] == EMPTY_EDGE

    fun edges() = edges

    fun vertices() = vertices

    fun adj(v: Int): Iterable<Edge> {
        val a = LinkedList<Edge>()
        for (i in 0 until vertices) {
            if (data[v][i] != EMPTY_EDGE) {
                a.add(Edge(v,i, data[v][i]))
            }
        }
        return a
    }
}