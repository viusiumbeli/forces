package jalg.answers.chapter1.section3


fun main() {
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.removeAfter(Stack.Node(0))
    stack.forEach { println(it) }
}