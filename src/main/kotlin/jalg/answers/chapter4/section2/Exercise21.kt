package jalg.answers.chapter4.section2

import jalg.chapter4.Digraph
import java.util.*

class Exercise21(private val digraph: Digraph) {
    fun bop(v: Int, w: Int): Int {
        val reverse = reverse(digraph)
        val distancev = bfs(reverse, v)
        val distancew = bfs(reverse, w)

        var minDistance = Int.MAX_VALUE
        for (i in 0 until digraph.vertices()) {
            if (distancev[i] != -1 && distancew[i] != -1 && distancev[i] + distancew[i] < minDistance) {
                minDistance = distancev[i] + distancew[i]
            }
        }
        return minDistance
    }

    private fun reverse(digraph: Digraph): Digraph {
        val a = Digraph(digraph.vertices())
        for (i in 0 until digraph.vertices()) {
            for (e in digraph.adj(i)) {
                a.addEdge(e, i)
            }
        }
        return a
    }

    private fun bfs(digraph: Digraph, v: Int): Array<Int> {
        val visited = BooleanArray(digraph.vertices()) { false }
        val distance = Array(digraph.vertices()) { -1 }
        distance[v] = 0
        visited[v] = true
        val queue = LinkedList<Int>()
        queue.push(v)
        while (queue.isNotEmpty()) {
            val c = queue.removeLast()
            for (e in digraph.adj(c)) {
                if (!visited[e]) {
                    queue.push(e)
                    visited[e] = true
                    distance[e] = distance[c] + 1
                }
            }
        }
        return distance
    }
}

fun main() {
    val digraph1 = Digraph(5)
    digraph1.addEdge(0, 1)
    digraph1.addEdge(1, 2)
    digraph1.addEdge(0, 3)
    digraph1.addEdge(3, 4)
    val a = Exercise21(digraph1)
    println(a.bop(2, 4))
}