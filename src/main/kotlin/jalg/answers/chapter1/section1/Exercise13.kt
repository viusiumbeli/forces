package jalg.answers.chapter1.section1

fun main() {
    val d = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            print(d[j][i])
            print(" ")
        }
        println()
    }
}