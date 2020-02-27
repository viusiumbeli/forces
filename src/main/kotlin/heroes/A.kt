package heroes

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    for (i in 0 until n) {
        var res: String
        val c = sc.nextInt()
        if (c > 999) {
            var cel = c / 1000
            var ost = c % 1000
            if (cel < 1000 && ost >= 500)
                cel++
            if (cel > 999) {
                ost = cel % 1000
                cel /= 1000
                if (ost >= 500)
                    cel++
                res = "${cel}M"
            } else
                res = "${cel}K"

        } else
            res = c.toString()
        println(res)
    }
}