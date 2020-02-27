package jalg.answers.chapter1.section4

fun main() {
    val data = intArrayOf(0, 0, 0, 1, 2, 3, 4, 4, 4, 4, 5, 6)
    val left = searchC(data, 0, data.lastIndex, 5)
    val right = searchR(data, 0, data.lastIndex, 5)
    println(right - left + 1)
}

fun searchC(data: IntArray, lo: Int, hi: Int, key: Int): Int {
    if (lo > hi) {
        return -1
    }
    val mid = (lo + hi) / 2
    if (key < data[mid])
        return searchC(data, lo, mid - 1, key)
    if (key > data[mid])
        return searchC(data, mid + 1, hi, key)

    val psi = searchC(data, lo, mid - 1, key)
    return if (psi == -1) mid else psi
}

fun searchR(data: IntArray, lo: Int, hi: Int, key: Int): Int {
    if (lo > hi) {
        return -1
    }
    val mid = (lo + hi) / 2
    if (key < data[mid])
        return searchR(data, lo, mid - 1, key)
    if (key > data[mid])
        return searchR(data, mid + 1, hi, key)

    val pli = searchR(data, mid + 1, hi, key)
    return if (pli == -1) mid else pli
}
