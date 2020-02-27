package jalg.answers.chapter1.section4

fun main() {
    val data = intArrayOf(0, 1, 2, 3, 4, 4, 4, 4, 5, 6)
    val index = search(data, 0, data.lastIndex, 0)
    println(index)
}

fun search(data: IntArray, lo: Int, hi: Int, key: Int): Int {
    if (lo > hi) {
        return -1
    }
    val mid = (lo + hi) / 2
    if (key < data[mid])
        return search(data, lo, mid - 1, key)
    if (key > data[mid])
        return search(data, mid + 1, hi, key)

    val psi = search(data, lo, mid - 1, key)
    return if (psi == -1) mid else psi
}
