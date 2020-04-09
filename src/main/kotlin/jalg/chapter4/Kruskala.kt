package jalg.chapter4

import java.util.*

class Kruskala(graph: WGraph) {
    private val pq = PriorityQueue<Edge>()
    private val visited = BooleanArray(graph.vertices())
    private val mst = mutableListOf<Edge>()

    init {
        for (i in 0 until graph.vertices())
            pq.addAll(graph.adj(i))

        while (pq.isNotEmpty()) {
            val min = pq.poll()
            if (visited[min.v] && visited[min.w]) continue
            mst.add(min)
            visited[min.v] = true
            visited[min.w] = true
        }
    }

    fun mst() = mst
}

fun main() {
    val wGraph = WGraph(8)
    wGraph.addEdge(Edge(4, 5, 35))
    wGraph.addEdge(Edge(4, 7, 37))
    wGraph.addEdge(Edge(5, 7, 28))
    wGraph.addEdge(Edge(0, 7, 16))
    wGraph.addEdge(Edge(1, 5, 32))
    wGraph.addEdge(Edge(0, 4, 38))
    wGraph.addEdge(Edge(2, 3, 17))
    wGraph.addEdge(Edge(1, 7, 19))
    wGraph.addEdge(Edge(0, 2, 26))
    wGraph.addEdge(Edge(1, 2, 36))
    wGraph.addEdge(Edge(1, 3, 29))
    wGraph.addEdge(Edge(2, 7, 34))
    wGraph.addEdge(Edge(6, 2, 40))
    wGraph.addEdge(Edge(3, 6, 52))
    wGraph.addEdge(Edge(6, 0, 58))
    wGraph.addEdge(Edge(6, 4, 93))
    val a = Kruskala(wGraph)
    println(a.mst())
}