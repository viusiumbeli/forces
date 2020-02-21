package jalg.answers.chapter1.section1

fun main() {
    println(mystery(2, 25))
    println(mystery(3, 11))
}

fun mystery(a: Int, b: Int): Int {
    if (b == 0) return 0
    return if (b % 2 == 0) {
        mystery(a + a, b / 2)
    } else {
        mystery(a + a, b / 2) + a
    }
}