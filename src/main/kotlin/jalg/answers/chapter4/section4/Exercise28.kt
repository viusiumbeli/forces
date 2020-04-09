package jalg.answers.chapter4.section4

import jalg.chapter4.Edge
import java.util.*

class Exercise28(graph: WGraph) {
    private lateinit var graphC: WGraph
    private val pathTo = IntArray(graph.vertices())
    private val distTo = IntArray(graph.vertices()) { Int.MAX_VALUE }
    private val pq = TreeMap<Int, Int>()

    init {
        makeCopyAndInvertWeight(graph)
        findMinimumDistance()
    }

    private fun findMinimumDistance() {
        pathTo[0] = 0
        pq[0] = 0
        distTo[0] = 0
        while (pq.isNotEmpty()) {
            val pollFirstEntry = pq.pollFirstEntry()
            visit(pollFirstEntry.value)
        }
    }

    private fun visit(v: Int) {
        for (e in graphC.adj(v)) {
            if (distTo[e.w] > distTo[v] + e.weight) {
                distTo[e.w] = distTo[v] + e.weight
                pathTo[e.w] = v
                pq[e.weight] = e.w
            }
        }
    }

    private fun makeCopyAndInvertWeight(graph: WGraph) {
        this.graphC = WGraph(graph.vertices())
        for (i in 0 until graph.vertices()) {
            for (e in graph.adj(i)) {
                val edge = Edge(e.v, e.w, -e.weight)
                graphC.addEdge(edge)
            }
        }
    }

    fun distTo() = distTo
}

fun main() {
    val graph = WGraph(6)
    graph.addEdge(Edge(0, 1, 1))
    graph.addEdge(Edge(0, 2, 2))
    graph.addEdge(Edge(0, 3, 3))
    graph.addEdge(Edge(2, 4, 4))
    graph.addEdge(Edge(3, 5, 5))
    val a = Exercise28(graph)
    a.distTo().forEach { println(it) }
}