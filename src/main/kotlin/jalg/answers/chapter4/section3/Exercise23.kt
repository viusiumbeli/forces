package jalg.answers.chapter4.section3

import jalg.chapter4.Edge
import jalg.chapter4.WGraph
import java.util.*

class Exercise23(private val graph: WGraph) {
    private val visited = BooleanArray(graph.vertices()) { false }
    private val visitedDfs = BooleanArray(graph.vertices()) { false }
    private val pathTo = IntArray(graph.vertices())
    private val mst = LinkedList<Edge>()

    fun addEdge(v: Int, w: Int, weight: Int) {
        if (visited[v] && visited[w]) {
            for (i in 0 until graph.vertices()) {
                visitedDfs[i] = false
                pathTo[i] = -1
            }
            val edge = Edge(v, w, weight)
            mst.add(edge)
            graph.addEdge(edge)
            visited[v] = true
            visited[w] = true
            dfs(0, 0)
            return
        }

        val edge = Edge(v, w, weight)
        mst.add(edge)
        graph.addEdge(edge)
        visited[v] = true
        visited[w] = true
    }

    private fun dfs(v: Int, u: Int): Boolean {
        visitedDfs[v] = true
        for (e in graph.adj(v)) {
            if (e.w == v || e.w == u) {
                continue
            }
            if (!visitedDfs[e.w]) {
                pathTo[e.w] = v
                if (dfs(e.w, v)) return true
            } else {
                var x = v
                var maxE = e
                while (x != e.w && x != -1) {
                    for (p in graph.adj(x))
                        if (p.v == x && p.w == pathTo[x] && p.weight > maxE.weight)
                            maxE = p
                    x = pathTo[x]
                }
                for (p in graph.adj(x))
                    if (p.v == x && p.w == pathTo[x] && p.weight > maxE.weight)
                        maxE = p
                val iterator = mst.iterator()
                while (iterator.hasNext()) {
                    val next = iterator.next()
                    if ((next.v == maxE.v && next.w == maxE.w) || (next.v == maxE.w && next.w == maxE.v))
                        iterator.remove()
                }
                graph.removeEdge(maxE)
                return true
            }
        }
        return false
    }

    fun mst() = mst
}

fun main() {
    val graph = WGraph(7)
    val a = Exercise23(graph)
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