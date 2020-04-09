package jalg.chapter4

import java.util.*

class Prima(graph: WGraph) {
    private val pq = PriorityQueue<Edge>(graph.edgesCount())
    private val visited = BooleanArray(graph.vertices()) { false }
    private val mst = LinkedList<Edge>()

    init {
        pq.addAll(graph.adj(0))
        visited[0] = true
        while (pq.isNotEmpty()) {
            val first = pq.poll()
            if (!(visited[first.v] && visited[first.w])) {
                visited[first.w] = true
                visited[first.v] = true
                for (e in graph.adj(first.v))
                    if (!(visited[e.v] && visited[e.w]))
                        pq.add(e)
                for (e in graph.adj(first.w))
                    if (!(visited[e.v] && visited[e.w]))
                        pq.add(e)
                mst.add(first)
            }
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
    val a = Prima(wGraph)
    println(a.mst())
}