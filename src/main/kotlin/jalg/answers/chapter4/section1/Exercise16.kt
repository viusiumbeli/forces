package jalg.answers.chapter4.section1

import jalg.chapter4.Graph
import java.util.*
import kotlin.math.max
import kotlin.math.min

class Exercise16(private val graph: Graph) {
    fun eccentricity(vertex: Int): Int {
        val distToAll = distToAll(vertex)
        var max = 0
        for (e in distToAll) {
            if (e != Int.MAX_VALUE) {
                max = max(max, e)
            }
        }
        return max
    }

    fun diameter(): Int {
        var max = 0
        for (v in 0 until graph.v()) {
            max = max(max, eccentricity(v))
        }
        return max
    }

    fun radius(): Int {
        var min = 0
        for (v in 0 until graph.v()) {
            min = min(min, eccentricity(v))
        }
        return min
    }

    fun distToAll(from: Int): IntArray {
        val distTo = IntArray(graph.size) { Int.MAX_VALUE }
        val queue = LinkedList<Int>()
        queue.push(from)
        distTo[from] = 0
        while (queue.isNotEmpty()) {
            val w = queue.pop()
            for (v in graph.adj(w)) {
                if (distTo[w] + 1 < distTo[v]) {
                    distTo[v] = distTo[w] + 1
                    queue.push(v)
                }
            }
        }
        return distTo
    }

}

fun main() {
    val g = Graph(4)
    g.addEdge(1, 2)
    g.addEdge(1, 3)
    g.addEdge(2, 3)
    val a = Exercise16(g)

}