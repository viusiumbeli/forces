package jalg.answers.chapter1.section1

fun main() {
    val s = System.currentTimeMillis()
    for (i in 0 until 100) {
        println("$i = ${fs(i)}")
    }
    println("Elapsed time = ${System.currentTimeMillis() - s}")
}

fun f(n: Int): Long {
    if (n == 0) return 1
    if (n == 1) return 1
    return f(n - 1) + f(
        n - 2
    )
}

val state = Array(100) { 0L }

fun fs(n: Int): Long {
    if (n == 0) return 1
    if (n == 1) return 1
    if (state[n] != 0L) return state[n]
    state[n] = fs(n - 1) + fs(
        n - 2
    )
    return state[n]
}