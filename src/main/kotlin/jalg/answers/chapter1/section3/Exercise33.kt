package jalg.answers.chapter1.section3

fun main() {
    val stack = Deque<Int>()
    stack.pushLeft(1)
    stack.pushLeft(2)
    stack.pushLeft(3)
    stack.pushLeft(4)
    stack.pushRight(0)
    stack.pushRight(-1)
    stack.pushRight(-2)
    stack.pushLeft(5)
    println(stack.popLeft())
    println(stack.popLeft())
    println(stack.popRight())
    stack.forEach { println(it) }
}

//3 4 2 1 2 3 0