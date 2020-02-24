package jalg.answers.chapter1.section3

class ResizingArrayQueueOfStrings(var n: Int) {
    private var data = arrayOfNulls<String>(n)
    var start = 0
    var end = 0

    fun enqueue(item: String) {
        if (end >= n)
            resize(n * 2)
        data[end++] = item
    }

    private fun resize(len: Int) {
        val copy = arrayOfNulls<String>(len)
        for (i in 0 until (end - start))
            copy[i] = data[start + i]
        data = copy
        n = len
    }

    fun dequeue(): String? {
        if (start > end)
            throw NoSuchElementException()

        if (n / 4 == end - start) {
            resize(n / 2)
            end -= start
            start = 0
        }

        return data[start++]
    }
}

fun main() {
    val data = ResizingArrayQueueOfStrings(4)
    data.enqueue("1")
    data.enqueue("2")
    data.enqueue("3")
    data.enqueue("4")
    data.enqueue("5")
    data.enqueue("6")
    println(data.dequeue())
    println(data.dequeue())
    println(data.dequeue())
    println(data.dequeue())
    println(data.dequeue())
    println(data.dequeue())
    data.enqueue("7")
    println(data.dequeue())
}