package jalg.answers.chapter1.section2

fun main() {
    println(evclid(13, 9))
    println(evclidWh(13, 9))
}

fun evclid(p: Int, q: Int): Int {
    if (q <= 0)
        return p
    val r = p % q
    return evclid(q, r)
}

fun evclidWh(p: Int, q: Int): Int {
    var p0 = p
    var q0 = q
    while (q0 != 0) {
        val t = q0
        q0 = p0 % q0
        p0 = t
    }
    return p0
}