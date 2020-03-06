package jalg.answers.chapter2.section4

import edu.princeton.cs.algs4.StdRandom
import edu.princeton.cs.algs4.Stopwatch
import jalg.chapter2.PriorityQueue
import kotlin.math.sqrt

data class Triple(
    val first: Double,
    val second: Double,
    val third: Double
) : Comparable<Triple> {
    override fun compareTo(other: Triple) =
        (sqrt(first * first + second * second + third * third) -
                sqrt(other.first * other.first + other.second * other.second + other.third * other.third)).toInt()
}

fun main() {
    val m = 10_000
    val n = 1_000_000
    val a = PriorityQueue<Triple>(m)
    val stopwatch = Stopwatch()
    for (i in 0..n) {
        a.insert(Triple(StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform()))
        if (a.size() == m) {
            a.delMin()
        }
    }
    val elapsedTime = stopwatch.elapsedTime()
    for (i in 1 until m) {
        println(a.min())
        a.delMin()
    }
    println(elapsedTime)
}