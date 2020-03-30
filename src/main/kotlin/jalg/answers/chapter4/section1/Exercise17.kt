package jalg.answers.chapter4.section1

import jalg.chapter4.Graph
import java.util.*
import kotlin.math.min

class Exercise17(private val graph: Graph) {
    private val disto = IntArray(graph.size)
    private val edjto = IntArray(graph.size)

    fun girth(): Int {
        var girth = Int.MAX_VALUE
        for (i in 1 until graph.v())
            girth = min(girth, girth(i))
        return girth
    }

    private fun girth(vertex: Int): Int {
        distTo(vertex)
        val queue = LinkedList<Int>()
        queue.push(vertex)
        val visited = BooleanArray(graph.size) { false }
        visited[vertex]=true
        var minDist = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            for (e in graph.adj(pop)) {
                if (!visited[e]) {
                    visited[e] = true
                    queue.push(e)
                } else if (e != edjto[pop]) {
                    minDist = min(minDist, disto[pop] + disto[e] + 1)
                }
            }
        }
        return minDist
    }

    private fun distTo(vertex: Int) {
        for (i in disto.indices)
            disto[i] = 0
        for (i in edjto.indices)
            edjto[i] = 0
        val visited = BooleanArray(graph.size) { false }
        val queue = LinkedList<Int>()
        queue.push(vertex)
        visited[vertex] = true
        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            for (e in graph.adj(pop)) {
                if (!visited[e]) {
                    visited[e] = true
                    queue.push(e)
                    disto[e] = disto[pop] + 1
                    edjto[e] = pop
                }
            }
        }
    }
}

fun main() {
    val g = Graph(4)
    g.addEdge(1, 2)
    g.addEdge(1, 3)
    g.addEdge(2, 3)
    val a = Exercise17(g)
    println(a.girth())
}