package train.cgr7

import java.math.BigInteger

fun main() {
    val t = readLine()!!.toInt()
    ffor@ for (i in 0 until t) {
        val n = readLine()!!.toInt()
        var s = BigInteger.ONE
        for (j in 0 until n - 1) {
            s = s.times(BigInteger.TEN).add(BigInteger.ONE)
        }
        val last = s.times(9.toBigInteger())
        loop@ while (s <= last) {
            var aux = s
            while (aux > BigInteger.ZERO) {
                val mod = aux.mod(BigInteger.TEN)
                aux = aux.div(BigInteger.TEN)
                if (mod == BigInteger.ZERO) {
                    s = s.add(BigInteger.ONE)
                    continue@loop
                }
                if (s.mod(mod) == BigInteger.ZERO) {
                    s = s.add(BigInteger.ONE)
                    continue@loop
                }
            }
            println(s)
            continue@ffor
        }
        println(-1)
    }
}