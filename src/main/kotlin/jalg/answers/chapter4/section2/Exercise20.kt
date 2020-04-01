package jalg.answers.chapter4.section2

import jalg.chapter4.Digraph
import java.util.*

class Exercise19(private val graph: Digraph) {
    private val cycle = LinkedList<Int>()
    private val visited = Array(graph.vertices()) { BooleanArray(graph.vertices()) { false } }

    fun euler(start: Int, v: Int): Boolean {
        if (graph.edges() == cycle.size) {
            if (cycle.first == start) {
                return true
            }
        }
        for (e in graph.adj(v)) {
            if (!visited[v][e]) {
                cycle.push(e)
                visited[v][e] = true
                if (euler(start, e)) {
                    return true
                }
                visited[v][e] = false
                cycle.removeLast()
            }
        }
        return false
    }
}

fun main() {
    val graph = Digraph(5)
    graph.addEdge(0, 1)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 0)
    graph.addEdge(3, 1)
    graph.addEdge(2, 3)
    val a = Exercise19(graph)
    println(a.euler(0, 0))
}