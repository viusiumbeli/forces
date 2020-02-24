package jalg.answers.chapter1.section3

class RingBuffer<T>(val n: Int) {
    private var data: Array<T?> = arrayOfNulls<Any?>(n) as Array<T?>
    var head = 0
    var tail = 0
    var size = 0

    fun enqueue(item: T): Boolean {
        if (size < n) {
            data[head] = item
            head++
            head %= n
            size++
            return true
        }
        return false
    }

    fun dequeue(): T? {
        if (size == 0) {
            throw NoSuchElementException()
        }

        val item = data[tail]
        data[tail] = null
        tail++
        tail %= n
        size--
        return item
    }

}