package jalg.answers.chapter4.section2

import jalg.chapter4.Digraph
import java.util.*


class Exercise9(private val digraph: Digraph) {
    private val visited = BooleanArray(digraph.vertices()) { false }
    private val topological = LinkedList<Int>()

    init {
        for (i in 0 until digraph.vertices()) {
            if (!visited[i]) {
                dfs(i)
            }
        }
    }

    private fun dfs(i: Int) {
        visited[i] = true
        for (e in digraph.adj(i)) {
            if (!visited[e]) {
                dfs(e)
            }
        }
        topological.push(i)
    }

    fun isTranspositionTopological(transposition: List<Int>) = topological == transposition
}

fun main() {
    val digraph = Digraph(4)
    digraph.addEdge(0, 1)
    digraph.addEdge(1, 2)
    digraph.addEdge(2, 3)
    digraph.addEdge(3, 0)
    digraph.addEdge(3, 1)

    val transposition = listOf(3, 2, 1, 0)
    val a = Exercise9(digraph)
    println(a.isTranspositionTopological(transposition))
    val transposition2 = listOf(1, 2, 3, 0)
    println(a.isTranspositionTopological(transposition2))

    val digraph1 = Digraph(3)
    digraph1.addEdge(0, 1)
    digraph1.addEdge(0, 2)
    digraph1.addEdge(1, 2)

    val topologicalOrder1: MutableList<Int> = ArrayList()
    topologicalOrder1.add(0)
    topologicalOrder1.add(1)
    topologicalOrder1.add(2)
    val b = Exercise9(digraph1)
    println(b.isTranspositionTopological(topologicalOrder1))

}