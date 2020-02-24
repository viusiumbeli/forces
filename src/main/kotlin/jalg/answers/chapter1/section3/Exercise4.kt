package jalg.answers.chapter1.section3


fun main() {
    val s = "[(])"
    val stack = Stack<Int>()

    var res = true
    for (c in s.chars()) {
        when (c) {
            93 -> stack.pop().takeIf { !it.isPresent || it.get() != 91 }?.let { res = false }
            125 -> stack.pop().takeIf { !it.isPresent || it.get() != 123 }?.let { res = false }
            41 -> stack.pop().takeIf { !it.isPresent || it.get() != 40 }?.let { res = false }
            else -> stack.push(c)
        }
    }
    println(res)
}