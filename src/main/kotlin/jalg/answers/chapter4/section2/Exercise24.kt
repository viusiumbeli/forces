package jalg.answers.chapter4.section2

import jalg.chapter4.Digraph
import java.util.*

class Exercise24(private val digraph: Digraph) {
    private val cycle = LinkedList<Int>()
    private val visited = Array(digraph.vertices()) { false }

    fun hamilton(): Boolean {
        for (i in visited.indices) {
            visited[i] = false
        }
        cycle.clear()
        cycle.push(0)
        return hamiltonDfs(0)
    }

    private fun hamiltonDfs(v: Int): Boolean {
        if (cycle.size == digraph.vertices()) {
            if (cycle.first == 0) {
                return true
            }
            cycle.pop()
            visited[v] = false
            return false
        }
        for (e in digraph.adj(v)) {
            if (!visited[e]) {
                cycle.push(e)
                visited[e] = true
                if (hamiltonDfs(e)) {
                    return true
                }
            }
        }
        visited[v] = false
        cycle.pop()
        return false
    }
}

fun main() {
    val digraph1 = Digraph(4)
    digraph1.addEdge(0, 1)
    digraph1.addEdge(1, 2)
    digraph1.addEdge(2, 3)
//    digraph1.addEdge(3, 0)
    val a = Exercise24(digraph1)
    println(a.hamilton())
}