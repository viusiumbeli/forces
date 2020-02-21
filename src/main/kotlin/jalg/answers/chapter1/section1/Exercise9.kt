package jalg.answers.chapter1.section1

fun main() {
    var x = 5
    var s = ""
    while (x != 0) {
        val l = x and 1
        s += l
        x = x shr 1
    }
    println(s)
}