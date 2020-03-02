package jalg.answers.chapter2.section3

fun main() {
    val a = intArrayOf(3, 4, 3, 3, 3, 4, 4, 4, 3)
    sort(a)
    a.forEach { println(it) }
}

private fun sort(a: IntArray) {
    var l = 0
    var h = a.lastIndex
    val pivot = a[l]
    var i = 0
    while (i < h)
        when {
            a[i] > a[pivot] -> {
                val tmp = a[h]
                a[h--] = a[i]
                a[i++] = tmp
            }
            a[i] < a[pivot] -> {
                val tmp = a[l]
                a[l++] = a[i]
                a[i++] = tmp
            }
            a[l] == a[pivot] -> i++
        }
}