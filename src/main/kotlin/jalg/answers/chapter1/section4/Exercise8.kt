package jalg.answers.chapter1.section4

fun main() {
    val data = intArrayOf(0, 1, 2, 3, 1, 5, 6, 7, 2, 2)
    sortData(data, 0, data.lastIndex)
    var res = 0
    for (i in 0 until data.lastIndex)
        if (findArray(data, i + 1, data.lastIndex, data[i]) > 0) {
            res++
        }
    println(res)
}

fun findArray(data: IntArray, start: Int, end: Int, key: Int): Int {
    var lo = start
    var hi = end
    while (lo <= hi) {
        val mid = (lo + hi) / 2
        when {
            key > data[mid] -> lo = mid + 1
            key < data[mid] -> hi = mid - 1
            else -> return data[mid]
        }
    }
    return -1
}

fun sortData(data: IntArray, s: Int, e: Int) {
    val mid = (s + e) / 2
    var l = s
    var r = e
    val opora = data[mid]
    while (l <= r) {
        while (data[l] < opora) l++
        while (data[r] > opora) r--
        if (l <= r) {
            val tmp = data[l]
            data[l] = data[r]
            data[r] = tmp
            l++
            r--
        }
    }
    if (l < e) sortData(data, l, e)
    if (r > s) sortData(data, s, r)
}

