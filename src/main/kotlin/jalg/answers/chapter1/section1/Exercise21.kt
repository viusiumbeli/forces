package jalg.answers.chapter1.section1

import edu.princeton.cs.algs4.StdIn

fun main() {
    val ar = Array(5) { StdIn.readLine() }
    for (e in ar) {
        val input = e.split(" ")
        System.out.printf(
            "%10s %4d %4d %4.2f\n",
            input[0],
            input[1].toLong(),
            input[2].toLong(),
            input[1].toFloat() / input[2].toFloat()
        )
    }
}