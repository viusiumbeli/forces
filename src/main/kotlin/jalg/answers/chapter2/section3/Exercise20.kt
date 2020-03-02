package jalg.answers.chapter2.section3

import jalg.answers.chapter1.section3.Stack

fun main() {
    val a = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    sort(a)
    a.forEach { println(it) }
}

private fun sort(a: IntArray) {
    val stack = Stack<Pair<Int, Int>>()
    stack.push(Pair(0, a.lastIndex))
    while (!stack.isEmpty()) {
        val pop = stack.pop().get()
        var l = pop.first
        var h = pop.second
        val m = (l + h) / 2
        val pivot = a[m]
        while (l <= h) {
            while (a[l] < pivot) l++
            while (a[h] > pivot) h--
            if (l <= h) {
                val temp = a[h]
                a[h] = a[l]
                a[l] = temp
                l++
                h--
            }
        }
        if (pop.first < h) stack.push(Pair(pop.first, h))
        if (l < pop.second) stack.push(Pair(l, pop.second))
    }
}
