package jalg.answers.chapter5.section2

import edu.princeton.cs.algs4.TST

fun main() {
    val a = TST<Int>()
    a.put("hello", 1)
    a.put("my", 1)
    a.put("name", 1)
    a.put("is", 1)
    println("what = ${a.contains("what")}")
    println("is = ${a.contains("is")}")
    println("your = ${a.contains("your")}")
    println("name = ${a.contains("name")}")
}