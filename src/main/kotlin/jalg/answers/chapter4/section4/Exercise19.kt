package jalg.answers.chapter4.section4

import jalg.chapter4.Edge
import java.util.*
import kotlin.math.min

class WGraph(size: Int) {
    private val vertices = Array(size) { LinkedList<Edge>() }
    private var edges = 0

    fun edgesCount() = edges

    fun vertices() = vertices.size

    fun adj(v: Int) = vertices[v]

    fun addEdge(edge: Edge) {
        vertices[edge.v].add(edge)
        edges++
    }
}

class Exercise19(private val graph: WGraph) {
    private val visited = BooleanArray(graph.vertices())
    private val pathTo = IntArray(graph.vertices())
    private val distTo = IntArray(graph.vertices())
    private var minSum = Int.MAX_VALUE

    init {
        findMinimumCycle(0)
    }

    private fun findMinimumCycle(v: Int) {
        visited[v] = true
        for (e in graph.adj(v)) {
            if (visited[e.w]) {
                pathTo[e.w] = v
                distTo[e.w] = e.weight
                cycleFound(e.w)
            } else {
                pathTo[e.w] = v
                distTo[e.w] = e.weight
                findMinimumCycle(e.w)
            }
        }
        visited[v] = false
    }

    private fun cycleFound(v: Int) {
        var x = pathTo[v]
        var sum = distTo[v]
        while (x != v) {
            sum += distTo[x]
            x = pathTo[x]
        }
        minSum = min(sum, minSum)
    }

    fun minSum() = minSum
}

fun main() {
    val graph = WGraph(5)
    graph.addEdge(Edge(0, 1, 1188))
    graph.addEdge(Edge(1, 0, -1187))
    graph.addEdge(Edge(1, 2, -4787))
    graph.addEdge(Edge(2, 1, 4797))
    graph.addEdge(Edge(2, 3, 481))
    graph.addEdge(Edge(3, 2, -478))
    graph.addEdge(Edge(3, 4, 50))
    graph.addEdge(Edge(4, 3, -80))
    graph.addEdge(Edge(4, 0, 2998))
    graph.addEdge(Edge(0, 4, -2999))
    graph.addEdge(Edge(0, 3, -3119))
    graph.addEdge(Edge(3, 0, 3120))
    graph.addEdge(Edge(3, 0, 3120))
    graph.addEdge(Edge(0, 2, -3598))
    graph.addEdge(Edge(2, 0, -3595))
    graph.addEdge(Edge(1, 4, 4201))
    graph.addEdge(Edge(4, 1, -4914))
    graph.addEdge(Edge(1, 3, -4305))
    graph.addEdge(Edge(3, 1, 4308))
    graph.addEdge(Edge(2, 4, -592))
    graph.addEdge(Edge(4, 2, 598))

    val a = Exercise19(graph)
    println(a.minSum())
}