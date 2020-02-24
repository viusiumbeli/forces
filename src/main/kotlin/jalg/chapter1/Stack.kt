package jalg.chapter1

class Stack<T>(var len: Int) {
    private var data: Array<T?> = arrayOfNulls<Any?>(len) as Array<T?>
    var n = 0

    fun push(x: T) {
        if (data.size == n)
            resize(data.size * 2)
        data[n++] = x
    }

    fun pop() {
        val e = data[--n]
        data[n] = null
        if (n > 0 && n == data.lastIndex / 4) resize(data.lastIndex / 2)
    }

    fun isEmpty() = n == 0

    fun size() = n

    fun resize(max: Int) {
        val tmp = arrayOfNulls<Any>(max) as Array<T?>
        for (i in 0 until n)
            tmp[i] = data[i]
        data = tmp
    }
}

fun main() {
    val s = Stack<Int>(2)
    s.push(1)
    s.push(2)
    s.push(3)
}