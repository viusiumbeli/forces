package jalg.answers.chapter1.section1

fun main() {
    val data = intArrayOf(1, 1, 2, 3, 5)
    println(equalKey(4, data))
}

fun equalKey(key: Int, data: IntArray): Int {
    var lo = 0
    var hi = data.lastIndex
    while (lo <= hi) {
        val mid = (lo + hi) / 2
        when {
            data[mid] < key -> lo = mid + 1
            data[mid] > key -> hi = mid - 1
            else -> return mid
        }
    }
    return lo
}