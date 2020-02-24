package jalg.answers.chapter1.section3

import edu.princeton.cs.algs4.Stack

fun main() {
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(1)
    stack.push(2)
    stack.forEach { println(it) }

    val copy = copyStack(stack)
    stack.push(5)
    stack.forEach { println(it) }
    copy.push(4)
    copy.forEach { println(it) }

}

fun copyStack(stack: Stack<Int>): Stack<Int> {
    val tmp = Stack<Int>()
    val copy = Stack<Int>()
    stack.size()
    for (e in stack) tmp.push(e)
    for (e in tmp) copy.push(e)
    return copy
}