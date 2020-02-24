package jalg.answers.chapter1.section3


fun main() {
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.insertAfter(Stack.Node(4), Stack.Node(2))
    stack.insertAfter(Stack.Node(4), Stack.Node(3))
    stack.forEach { println(it) }
}