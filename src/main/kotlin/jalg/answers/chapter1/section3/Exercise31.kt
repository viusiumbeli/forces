package jalg.answers.chapter1.section3

fun main() {
    val stack = StackD<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.pop())
    stack.push(4)
    println(stack.pop())
    println(stack.pop())
    stack.appendLast(0)
    println(stack.pop())
    stack.push(2)
    stack.prepend(StackD.NodeD(0), 3)
    stack.forEach { println(it) }
}

//3 4 2 1 2 3 0