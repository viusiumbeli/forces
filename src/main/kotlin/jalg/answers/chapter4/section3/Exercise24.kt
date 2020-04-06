package jalg.answers.chapter4.section3

import jalg.chapter4.Edge
import jalg.chapter4.WGraph
import java.util.*

class Exercise24(private val graph: WGraph) {
    private val visited = BooleanArray(graph.vertices())
    private val pq = PriorityQueue<Edge>(graph.vertices(), Collections.reverseOrder())

    init {
        pq.addAll(graph.edges())
        val iterator = pq.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            graph.removeEdge(next)
            for (i in visited.indices)
                visited[i] = false
            dfs(0)
            var separate = false
            for (i in visited.indices)
                if (!visited[i]) {
                    separate = true
                    break
                }
            if (separate) {
                graph.addEdge(next)
            } else {
                iterator.remove()
            }
        }

    }

    private fun dfs(i: Int) {
        visited[i] = true
        for (e in graph.adj(i)) {
            if (!visited[e.w]) {
                dfs(e.w)
            }
        }
    }

    fun mst(): Iterable<Edge> = pq
}


fun main() {
    val graph = WGraph(7)
    graph.addEdge(Edge(0, 2, 1))
    graph.addEdge(Edge(1, 2, 2))
    graph.addEdge(Edge(2, 4, 3))
    graph.addEdge(Edge(2, 3, 4))
    graph.addEdge(Edge(4, 6, 5))
    graph.addEdge(Edge(4, 3, 6))
    graph.addEdge(Edge(3, 5, 7))
    graph.addEdge(Edge(5, 6, 8))
    val a = Exercise24(graph)
    println(a.mst())
}