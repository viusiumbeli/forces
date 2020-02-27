package jalg.answers.chapter1.section4

fun main() {
    val data1 = intArrayOf(0, 0, 0, 1, 2, 3, 4, 4, 4, 4, 5, 6)
    val data2 = intArrayOf(0, 0, 0, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7,8)
    var index1 = 0
    var index2 = 0
    val res = mutableListOf<Int>()
    while (index1 < data1.size && index2 < data2.size) {
        when {
            data1[index1] < data2[index2] -> index1++
            data1[index1] > data2[index2] -> index2++
            else -> {
                res.add(data1[index1])
                while (index1 < data1.size && index2 < data2.size && data1[index1] == data2[index2] && data2[index2] == res.last()) {
                    index1++
                    index2++
                }
            }
        }
    }
    res.forEach { println(it) }
}