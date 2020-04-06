package jalg.answers.chapter4.section3

import jalg.chapter4.Edge
import java.util.*

class Exercise28(private val size: Int) {
    private val EMPTY = -1
    val graph = Array(size) { IntArray(size) { EMPTY } }
    private var edges = 0

    fun addEdge(v: Int, w: Int, weight: Int) {
        graph[v][w] = weight
        graph[w][v] = weight
        edges++
    }

    fun adj(v: Int) = graph[v]

    fun mst(): LinkedList<Edge> {
        val visited = BooleanArray(size)
        val pq = PriorityQueue<Int>(edges)
        val mst = LinkedList<Edge>()
        var v = 0
        var w = 0
        visit(v, visited, pq)
        while (pq.isNotEmpty()) {
            val min = pq.poll()
            for (i in graph.indices)
                for (j in graph[i].indices)
                    if (graph[i][j] == min) {
                        v = i
                        w = j
                        break
                    }
            if (!(visited[v] && visited[w])) {
                mst.add(Edge(v, w, min))
                if (!visited[w])
                    visit(w, visited, pq)
                if (!visited[v])
                    visit(v, visited, pq)
            }
        }
        return mst
    }

    private fun visit(v: Int, visited: BooleanArray, pq: PriorityQueue<Int>) {
        visited[v] = true
        for (e in adj(v).indices)
            if (graph[v][e] != EMPTY && !visited[e])
                pq.add(graph[v][e])
    }
}

fun main() {
    val a = Exercise28(7)
    a.addEdge(0, 2, 1)
    a.addEdge(1, 2, 2)
    a.addEdge(2, 4, 3)
    a.addEdge(2, 3, 4)
    a.addEdge(4, 6, 5)
    a.addEdge(4, 3, 6)
    a.addEdge(3, 5, 7)
    a.addEdge(5, 6, 8)
    println(a.mst())
}