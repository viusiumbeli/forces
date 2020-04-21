package jalg.answers.chapter5.section2

import edu.princeton.cs.algs4.TST

fun main() {
    val a = TST<Int>()
    val string = "cgcgggcgcg"
    for (i in 0..string.length - 3) {
        val substring = string.substring(i, i + 3)
        a.put(substring, 1)
    }
    println(a.size())
}