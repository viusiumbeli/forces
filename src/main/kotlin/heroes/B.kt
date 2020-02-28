package heroes

import java.util.*

fun rs() = readLine()!!
fun ri() = rs().toInt()
fun rsl() = rs().split(" ")
fun ril() = rsl().map { it.toInt() }

fun main() {
    var t = ri()
    while (t-- > 0) {
        val n = ri()
        val mp = TreeMap<Int, Int>()
        for (i in 1..n) {
            val tmp = ril()
            val a = tmp[0]
            val b = tmp[1]
            mp[a] = mp.getOrDefault(a, 0) + 1
            mp[b + 1] = mp.getOrDefault(b + 1, 0) - 1
        }
        var cnt = 0
        var res = -1
        for (p in mp.entries) {
            cnt += p.value
            if (cnt == 1) {
                res = p.key
                break;
            }
        }
        println(res)

    }


}
/*
1
4
3 9
4 7
5 6
3 4
 */