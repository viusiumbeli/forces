package jalg.answers.chapter4.section1

import edu.princeton.cs.algs4.Bag
import java.util.*

class Exercise29(val size: Int) {
    private val adj = Array<Bag<Int>>(size) { Bag() }
    private var e = 0
    private var visited: Array<BooleanArray>? = null
    private var marked = BooleanArray(size)
    private val path = LinkedList<Int>()
    fun v() = size

    fun e() = e

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        e++
    }

    fun adj(v: Int) = adj[v]

    fun eulerPath(): List<Int> {
        path.clear()
        if (hasEulerCycle()) {
            visited = Array(size) { BooleanArray(size) { false } }
            findEulerCycle(0)
        }
        return path
    }

    private fun findEulerCycle(v: Int) {
        for (e in adj(v)) {
            if (!visited!![v][e]) {
                visited!![v][e] = true
                visited!![e][v] = true
                findEulerCycle(e)
            }
        }
        path.push(v)
    }

    private fun hasEulerCycle(): Boolean {
        for (i in adj.indices) {
            if (adj(i).size() % 2 == 1) {
                return false
            }
        }
        return true
    }

    fun hamiltonPath(): List<Int> {
        path.clear()
//        if (hasEulerCycle()) {
        findHamiltonCycle(0)
//        }
        return path
    }

    private fun findHamiltonCycle(v: Int): Boolean {
        path.push(v)
        if (path.size == size) {
            if (adj(v).contains(path.last)) return true
            path.pop()
            return false
        }
        marked[v] = true
        for (w in adj(v)) {
            if (!marked[w]) {
                if (findHamiltonCycle(w)) {
                    return true
                }
            }
        }
        path.pop()
        marked[v] = false
        return false
    }

}

fun main() {
//    var a = Exercise29(10)
//    a.addEdge(0, 1)
//    a.addEdge(0, 2)
//    a.addEdge(0, 3)
//    a.addEdge(1, 3)
//    a.addEdge(1, 4)
//    a.addEdge(2, 5)
//    a.addEdge(2, 9)
//    a.addEdge(3, 6)
//    a.addEdge(4, 7)
//    a.addEdge(4, 8)
//    a.addEdge(5, 8)
//    a.addEdge(5, 9)
//    a.addEdge(6, 7)
//    a.addEdge(6, 9)
//    a.addEdge(7, 8)
//    println(a.eulerPath())
//    println(a.hamiltonPath())

    var a = Exercise29(10)
    a.addEdge(0, 1)
    a.addEdge(0, 2)
    a.addEdge(0, 3)
    a.addEdge(1, 3)
    a.addEdge(0, 3)
    a.addEdge(2, 5)
    a.addEdge(5, 6)
    a.addEdge(3, 6)
    a.addEdge(4, 7)
    a.addEdge(4, 8)
    a.addEdge(5, 8)
    a.addEdge(5, 9)
    a.addEdge(6, 7)
    a.addEdge(6, 9)
    a.addEdge(8, 8)
    println(a.eulerPath())
    println(a.hamiltonPath())

    a = Exercise29(10)
    a.addEdge(0, 1)
    a.addEdge(1, 2)
    a.addEdge(1, 3)
    a.addEdge(0, 3)
    a.addEdge(0, 4)
    a.addEdge(2, 5)
    a.addEdge(5, 6)
    a.addEdge(3, 6)
    a.addEdge(4, 7)
    a.addEdge(4, 8)
    a.addEdge(5, 8)
    a.addEdge(5, 9)
    a.addEdge(6, 7)
    a.addEdge(6, 9)
    a.addEdge(7, 8)
    println(a.eulerPath())
    println(a.hamiltonPath())

    a = Exercise29(10)
    a.addEdge(4, 7)
    a.addEdge(7, 9)
    a.addEdge(6, 2)
    a.addEdge(7, 3)
    a.addEdge(5, 0)
    a.addEdge(0, 2)
    a.addEdge(0, 8)
    a.addEdge(1, 6)
    a.addEdge(3, 9)
    a.addEdge(6, 3)
    a.addEdge(2, 8)
    a.addEdge(1, 5)
    a.addEdge(9, 8)
    a.addEdge(4, 5)
    a.addEdge(4, 7)
    println(a.eulerPath())
    println(a.hamiltonPath())

}