package jalg.chapter4

import java.util.*

data class Edge(val v: Int, val w: Int, val weight: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = this.weight - other.weight
}

class WGraph(size: Int) {
    private val vertices = Array(size) { LinkedList<Edge>() }
    private var edges = 0

    fun edgesCount() = edges

    fun vertices() = vertices.size

    fun adj(v: Int) = vertices[v]

    fun addEdge(edge: Edge) {
        vertices[edge.v].add(edge)
        vertices[edge.w].add(Edge(edge.w, edge.v, edge.weight))
        edges++
    }

    fun edges(): LinkedList<Edge> {
        val queue = LinkedList<Edge>()
        for (i in 0 until vertices())
            for (e in adj(i)) {
                if (!(queue.contains(Edge(e.w, e.v, e.weight)) || queue.contains(e))) {
                    queue.add(e)
                }
            }
        return queue
    }

    fun removeEdge(remove: Edge) {
        var iterator = adj(remove.v).iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next.w == remove.w) {
                iterator.remove()
            }
        }
        iterator = adj(remove.w).iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next.w == remove.v) {
                iterator.remove()
            }
        }
    }
}