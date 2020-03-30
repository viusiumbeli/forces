package jalg.answers.chapter4.section1

import jalg.chapter4.Graph
import java.util.*
import kotlin.math.min


class Exercise35 {
    data class Edge(var vertex1: Int, var vertex2: Int)

    private var count = 0

    private lateinit var low: IntArray
    private lateinit var time: IntArray

    fun findBridges(graph: Graph): List<Edge>? {
        low = IntArray(graph.v())
        time = IntArray(graph.v())
        val bridges: MutableList<Edge> = ArrayList()
        for (vertex in 0 until graph.v()) {
            low[vertex] = -1
            time[vertex] = -1
        }
        for (vertex in 0 until graph.v()) {
            if (time[vertex] == -1) {
                dfs(graph, vertex, vertex, bridges)
            }
        }
        return bridges
    }

    private fun dfs(graph: Graph, currentVertex: Int, sourceVertex: Int, bridges: MutableList<Edge>) {
        time[currentVertex] = count
        low[currentVertex] = count
        count++
        for (neighbor in graph.adj(currentVertex)) {
            if (time[neighbor] == -1) {
                dfs(graph, neighbor, currentVertex, bridges)
                low[currentVertex] = min(low[currentVertex], low[neighbor])
                if (low[neighbor] == time[neighbor]) {
                    bridges.add(
                        Edge(
                            currentVertex,
                            neighbor
                        )
                    )
                }
            } else if (neighbor != sourceVertex) {
                low[currentVertex] = min(low[currentVertex], time[neighbor])
            }
        }
    }

}

fun main() {
    val graph2 = Graph(6)
    graph2.addEdge(0, 1)
    graph2.addEdge(2, 1)
    graph2.addEdge(0, 2)
    graph2.addEdge(3, 5)
    graph2.addEdge(4, 5)
    graph2.addEdge(3, 4)
    graph2.addEdge(1, 5)

    val a = Exercise35()
    println(a.findBridges(graph2))
}