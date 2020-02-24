package jalg.answers.chapter1.section3


fun main() {
    val stack = Stack<String>()
    stack.push("1")
    stack.push("2")
    stack.push("3")
    val copy = copy(stack)
    copy.push("4")
    println(stack.pop().get())
    println(copy.pop().get())
    println(copy.pop().get())
}

fun copy(stack: Stack<String>): Stack<String> {
    val copy = Stack<String>()
    val tmp = Stack<String>()
    for (e in stack)
        tmp.push(e)
    for (e in tmp)
        copy.push(e)
    return copy
}
