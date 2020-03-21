package train.cgr7

import java.io.PrintWriter

val pw = PrintWriter(System.out, true)

fun main() {
    ffor@ for (i in 0 until readLine()!!.toInt()) {
        val chars = readLine()!!.toCharArray()
        if (isPalindrome(chars)) {
            println(chars)
        } else {
            for (j in chars.indices) {
                for (k in 0..chars.lastIndex) {
                    if (isPalindrome(chars, k, j)) {
                        println(chars, k, j)
                        continue@ffor
                    }
                }
            }
        }
    }
    pw.flush()
}

fun isPalindrome(chars: CharArray): Boolean {
    var l = 0
    var r = chars.lastIndex
    while (l <= r) {
        if (chars[l] != chars[r])
            return false
        l++
        r--
    }
    return true
}

fun println(chars: CharArray) {
    for (i in chars.indices)
        pw.print(chars[i])
    pw.println()
}


fun println(chars: CharArray, start: Int, len: Int) {
    val ran = (start) until start + len

    for (i in chars.indices)
        if (i !in ran)
            pw.print(chars[i])
    pw.println()
}

fun isPalindrome(chars: CharArray, start: Int, len: Int): Boolean {
    var l = 0
    var r = chars.lastIndex
    while (l <= r) {
        if (l == start)
            l += len
        if (r == start)
            r -= len
        if (l < chars.size && r >= 0 && chars[l] != chars[r])
            return false
        l++
        r--
    }
    return true
}
