package train.t71

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    for (i in 0..nextInt()) {
        val it = nextLine()
        println(if (it.length > 10) "${it.first()}${it.length - 2}${it.last()}" else it)
    }
}
