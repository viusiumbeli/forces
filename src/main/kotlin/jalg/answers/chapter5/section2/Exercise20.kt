package jalg.answers.chapter5.section2

import jalg.chapter5.TrieST
import java.util.regex.Pattern

fun main() {
    val a = TrieST<Int>()
    a.put("asfdgh", 1)
    a.put("qwerty", 1)
    a.put("zxcvb", 1)
    a.put("asd", 1)
    println(containsPrefix(a.root, "asfd", 0))
    println(containsPrefix(a.root, "asdf", 0))
    println(containsPrefix(a.root, "asd", 0))
}

fun containsPrefix(node: TrieST.Node<Int>?, prefix: String, d: Int): Boolean {
    if (node == null || d > prefix.length) {
        return false
    }
    if (d == prefix.length) {
        return true
    }
    val compile = Pattern.compile("[^A]*A{4}[^A]*")
    val compile2 = Pattern.compile("A{0,4}([^A]A{0,4})*")
    val compile3 = Pattern.compile("([^A]*A{4,}[^A]*)+")
    val compile4 = Pattern.compile(".*(AAAA)+.*")
    val compile5 = Pattern.compile("[ABCD]|[AVFS]")
    val compile6 = Pattern.compile("[01]*111[01]*")
    val compile7 = Pattern.compile("[^(110)]")
    val compile8 = Pattern.compile("(0([01])*0|1([01])*1)")
    val compile9 = Pattern.compile("(.).*($1)")
    val compile10 = Pattern.compile("(0|1(01*0)*1)*")
    Pattern.compile("A*|(A*BA*BA*)*")
    return containsPrefix(node.links[prefix[d].toInt() - 97], prefix, d + 1)
}
