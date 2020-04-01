package jalg.answers.chapter4.section2

import edu.princeton.cs.algs4.Stack
import jalg.chapter4.Digraph

class Exercise7(digraph: Digraph) {
    private val indegree = IntArray(digraph.vertices())
    private val outdegree = IntArray(digraph.vertices())

    init {
        for (i in 0 until digraph.vertices()) {
            outdegree[i] = digraph.adj(i).size()
            for (e in digraph.adj(i)) {
                indegree[e]++
            }
        }
    }

    fun indegree(v: Int) = indegree[v]

    fun outdegree(v: Int) = outdegree[v]

    fun sources(): Iterable<Int> {
        val stack = Stack<Int>()
        for (e in indegree) {
            if (e == 0) {
                stack.push(e)
            }
        }
        return stack
    }

    fun sinks(): Iterable<Int> {
        val stack = Stack<Int>()
        for (e in outdegree) {
            if (e == 0) {
                stack.push(e)
            }
        }
        return stack
    }

    fun isMap(): Boolean {
        for (e in outdegree) {
            if (e != 1) {
                return false
            }
        }
        return true
    }

}

fun main() {
    val digraph = Digraph(4)
    digraph.addEdge(0, 1)
    digraph.addEdge(1, 2)
    digraph.addEdge(2, 3)
    digraph.addEdge(3, 0)
    digraph.addEdge(3, 1)

    val a = Exercise7(digraph)
    println(a.indegree(1))
    println(a.isMap())
    println(a.sinks())
    println(a.sources())
}