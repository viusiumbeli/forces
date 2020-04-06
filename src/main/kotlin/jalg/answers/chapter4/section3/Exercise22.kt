package jalg.answers.chapter4.section3

import jalg.chapter4.Edge
import jalg.chapter4.WGraph
import java.util.*

class Exercise22(private val graph: WGraph) {
    private val pq = PriorityQueue<Edge>()
    private val visited = BooleanArray(graph.vertices())
    private val msts = mutableListOf<List<Edge>>()

    init {
        for (i in 0 until graph.vertices()) {
            for (j in 0 until graph.vertices())
                visited[j] = false
            msts.add(mst(i))
        }
    }

    private fun mst(i: Int): MutableList<Edge> {
        val mst = mutableListOf<Edge>()
        pq.addAll(graph.adj(i))
        while (pq.isNotEmpty()) {
            val min = pq.poll()
            if (visited[min.v] && visited[min.w]) continue
            visited[min.v] = true
            visited[min.w] = true
            mst.add(min)
            if (!visited[min.v])
                for (e in graph.adj(min.v))
                    if (!visited[min.w])
                        pq.add(e)
            if (!visited[min.w])
                for (e in graph.adj(min.w))
                    if (!visited[min.v])
                        pq.add(e)
        }
        return mst
    }

    fun msts() = msts
}