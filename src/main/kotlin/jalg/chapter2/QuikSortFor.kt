package jalg.chapter2


fun main() {
    val arr = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    quickSort(arr, 0, arr.lastIndex)
    println(arr.contentToString())
}

fun quickSort(arr: IntArray, start: Int, end: Int) {
    if (start >= end)
        return
    val partition = partition(arr, start, end)
    quickSort(arr, start, partition - 1)
    quickSort(arr, partition + 1, end)
}

fun partition(arr: IntArray, start: Int, end: Int): Int {
    var start = start
    val pivot = arr[end]
    for (i in start until end) {
        if (arr[i] < pivot) {
            val temp = arr[start]
            arr[start] = arr[i]
            arr[i] = temp
            start++
        }
    }
    val temp = arr[start]
    arr[start] = pivot
    arr[end] = temp
    return start
}