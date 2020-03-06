package jalg.answers.chapter2.section4

class Exercise1Array(val size: Int) {
    val a = IntArray(size)
    var n = 0

    infix fun insert(key: Int) {
        if (n < size) {
            a[n++] = key
        } else {
            var minI = 0
            for (i in 0 until n)
                if (a[i] < a[minI])
                    minI = i
            a[minI] = key
        }
    }

    fun max(): Int {
        if (n == 0)
            throw NoSuchElementException()

        var maxI = 0
        for (i in 0 until n)
            if (a[i] > a[maxI])
                maxI = i
        val maxv = a[maxI]
        a[maxI] = a[--n]
        return maxv
    }

}

fun main() {
    val a = Exercise1Array(3)
    a insert 3
    a insert 2
    a insert 1
    a insert 1
    a insert 2
    a insert 3
    a insert 4
    a insert 5
    a insert 6
    println(a.max())
    println(a.max())
    println(a.max())
    println(a.a.contentToString())
}