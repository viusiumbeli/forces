package jalg.answers.chapter2.section4

import kotlin.math.log10

class Exercise31(len: Int) {
    var a = IntArray(len)
    var n = 1

    fun size() = n

    private fun sink(k: Int) {
        var kc = k
        while (kc * 2 <= n) {
            var j = kc * 2
            if (j < n && a[j] > a[j + 1])
                j++
            if (a[kc] < a[j])
                break
            val tmp = a[j]
            a[j] = a[kc]
            a[kc] = tmp
            kc = j
        }
    }

    private fun swim(k: Int) {
        val li = findLadIndex(k)
        var kc = k
        while (kc > li) {
            swap(kc, kc / 2)
            kc /= 2
        }
    }

    private fun swap(l: Int, r: Int) {
        val tmp = a[l]
        a[l] = a[r]
        a[r] = tmp
    }

    private fun findLadIndex(k: Int): Int {
        val th = (log10(k.toDouble()) / log10(2.0)).toInt()
        val pi = IntArray(th)
        var i = k / 2
        var pii = 0
        while (i >= 1) {
            pi[pii++] = i
            i /= 2
        }

        var l = 0
        var h = th
        var ti = k
        while (l < h) {
            val m = (l + h) / 2
            when {
                a[pi[m]] < a[k] -> l = m + 1
                a[pi[m]] > a[k] -> {
                    h = m
                    ti = pi[m]
                }
            }
        }
        return ti
    }

    infix fun insert(node: Int) {
        a[n] = node
        swim(n++)
    }

    fun min() = a[1]

}

fun main() {
    val a = Exercise31(5)
    a insert 4
    a insert 3
    a insert 2
    a insert 5
    println(a.a.contentToString())
}