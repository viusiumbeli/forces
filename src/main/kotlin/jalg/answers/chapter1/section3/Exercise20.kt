package jalg.answers.chapter1.section3


fun main() {
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.newDelete(4)
    stack.forEach { println(it) }
}