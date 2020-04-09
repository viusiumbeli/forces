package jalg.answers.chapter4.section4

import jalg.chapter4.Edge
import jalg.chapter4.WGraph
import java.util.*

class Exercise7(private val graph: WGraph) {
    private val paths = mutableListOf<Array<Int>>()
    private val pq = TreeMap<Int, Int>()
    private val distTo = Array(graph.vertices()) { Int.MAX_VALUE }

    init {
        findPaths()
    }

    private fun findPaths() {
        paths.add(Array(graph.vertices()) { Int.MAX_VALUE })
        pq[0] = 0
        paths[0][0] = 0
        distTo[0] = 0
        while (pq.isNotEmpty()) {
            val min = pq.pollFirstEntry()
            visitMin(min.value)
        }
    }

    private fun duplicatePaths(to: Int, from: Int) {
        for (i in 0 until paths.size) {
            val element = paths[i].clone()
            element[to] = from
            paths.add(element)
        }
    }

    private fun visitMin(min: Int) {
        for (e in graph.adj(min)) {
            if (distTo[e.w] > distTo[min] + e.weight) {
                distTo[e.w] = distTo[min] + e.weight
                paths.forEach { it[e.w] = min }
                pq[e.weight] = e.w
            } else if (distTo[e.w] == distTo[min] + e.weight)
                duplicatePaths(e.w, min)
        }
    }

    fun distTo() = distTo
    fun paths() = paths
}

fun main() {
    val graph = WGraph(4)
    graph.addEdge(Edge(0, 1, 1))
    graph.addEdge(Edge(0, 2, 3))
    graph.addEdge(Edge(1, 2, 2))
    graph.addEdge(Edge(2, 3, 5))
    val a = Exercise7(graph)
//    a.distTo().forEach { println(it) }
    a.paths()[0].forEach { println(it) }
    a.paths()[1].forEach { println(it) }
}