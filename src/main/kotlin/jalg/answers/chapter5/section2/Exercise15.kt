package jalg.answers.chapter5.section2

import edu.princeton.cs.algs4.TST

fun main() {
    val a = TST<Int>()
    val string = "cgcgggcgcg"
//    val string = "renerene"
    for (j in 1..string.length) {
        for (i in 0..string.length - j) {
            val substring = string.substring(i, i + j)
            a.put(substring, 1)
        }
    }
    println(a.size())
}