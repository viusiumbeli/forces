package jalg.answers.chapter1.section3


fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.removeLast()
    stack.forEach { println(it) }
}