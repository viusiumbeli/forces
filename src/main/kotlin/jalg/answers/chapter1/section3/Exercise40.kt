package jalg.answers.chapter1.section3

fun main() {
    val moveToFront = MoveToFront<Int>()

    moveToFront.push(0)
    moveToFront.push(1)
    moveToFront.push(0)
    moveToFront.push(2)
    moveToFront.push(0)
    moveToFront.push(0)
    moveToFront.push(2)
    moveToFront.push(2)

    println(moveToFront.pop())
    println(moveToFront.pop())
    println(moveToFront.pop())
}