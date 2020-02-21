package jalg.answers.chapter1.section2


fun main() {
    println(mystery("ABCDDCBA"))
}

fun mystery(s: String): String {
    val n = s.length
    if (n <= 1) return s
    val a = s.substring(0, n / 2)
    val b = s.substring(n / 2, n)
    return mystery(b) + mystery(a)
}