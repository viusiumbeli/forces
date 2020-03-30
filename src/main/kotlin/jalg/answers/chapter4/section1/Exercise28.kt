package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag

class Exercise28(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0
    private var marked = BooleanArray(size) { false }
    private var hasCycle = false
    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]

    fun hasCycle(): Boolean {
        if (hasSelfLoop()) return false
        if (hasParallelEdges()) return false
        for (i in adj.indices) {
            if (!marked[i]) {
                marked[i] = true
                dfs(i, i)
            }
        }
        return hasCycle
    }

    private fun hasParallelEdges(): Boolean {
        val visited = BooleanArray(size) { false }
        for (i in adj.indices) {
            for (v in adj(i)) {
                if (visited[v]) {
                    return true
                }
                visited[v] = true
            }
            for (v in adj(i))
                visited[v] = false
        }
        return false
    }

    private fun hasSelfLoop(): Boolean {
        for (i in adj.indices) {
            for (e in adj(i)) {
                if (e == i) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(c: Int, from: Int) {
        for (neighbour in adj(c)) {
            if (!marked[neighbour]) {
                marked[neighbour] = true
                dfs(neighbour, c)
            } else if (neighbour != from) {
                hasCycle = true
            }
        }
    }
}

fun main() {
    val a = Exercise28(4)
    a.addEdge(0, 0)
    a.addEdge(0, 1)
    a.addEdge(1, 2)
    a.addEdge(2, 3)
    a.addEdge(3, 0)
    println(a.hasCycle())
}