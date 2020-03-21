package train.cgr7

import java.io.PrintWriter

fun readInts() = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

fun main() {
    val pw = PrintWriter(System.out, true)
    readLine()
    var max = 0
    val a = readInts()
    var aux: Int
    for (i in a.indices) {
        aux = a[i] + max
        if (aux > max)
            max = aux
        a[i] = aux
    }
    for (i in 0 until a.lastIndex) {
        pw.print(a[i])
        pw.print(" ")
    }
    pw.print(a[a.lastIndex])
    pw.flush()
}