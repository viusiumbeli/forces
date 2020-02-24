package jalg.answers.chapter1.section3

fun main() {
    val queue = RingBuffer<Int>(3)
    queue.enqueue(0)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)

    println(queue.dequeue())
    println(queue.dequeue())

    queue.enqueue(5)
    queue.enqueue(6)

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
}