package jalg.answers.chapter2.section4

import edu.princeton.cs.algs4.MaxPQ

class Exercise27<K : Comparable<K>> : MaxPQ<K>() {
    var min: K? = null
    override fun insert(x: K) {
        super.insert(x)
        if (min == null) {
            min = x
        } else {
            if (min!! > x) {
                min = x
            }
        }
    }

    fun min() = min
}

fun main() {
    val a = Exercise27<Int>()
    a.insert(4)
    a.insert(44)
    a.insert(445)
    a.insert(2)
    a.insert(1)
    println(a.min())
}