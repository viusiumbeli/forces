package jalg.answers.chapter1.section1

fun main() {
    println(evklid(1111111, 1234567))
}

fun evklid(p: Int, q: Int): Int {
    if (q == 0) return p
    val r = p % q
    return evklid(q, r)
}