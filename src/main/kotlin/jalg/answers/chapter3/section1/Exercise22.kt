package jalg.answers.chapter3.section1

class Exercise22(len: Int) {
    val keys = IntArray(len)
    val values = arrayOfNulls<String>(len)
    var n = 0

    fun put(key: Int, value: String?) {
        if (value == null) {
            delete(key)
        }

        for (i in 0 until n) {
            if (keys[i] == key)
                values[i] = value
        }

        shr(n++)
        keys[0] = key
        values[0] = value
    }

    private fun shr(last: Int) {
        for (j in last downTo 1) {
            keys[j] = keys[j - 1]
            values[j] = values[j - 1]
        }
    }

    private fun delete(key: Int) {
        for (i in 0 until n)
            if (keys[i] == key) {
                for (j in i until --n) {
                    keys[j] = keys[j + 1]
                    values[j] = values[j + 1]
                }
                break
            }
    }

    fun get(key: Int): String? {
        var pos = -1
        for (i in 0 until n)
            if (keys[i] == key) {
                pos = i
                break
            }
        if (pos < 0)
            return null

        val aux = values[pos]
        shr(pos)
        keys[0] = key
        values[0] = aux
        return aux
    }
}

fun main() {
    val a = Exercise22(4)
    a.put(4, "5")
    a.put(3, "7")
    a.put(2, "8")
    a.put(6, "1")
    println(a.get(3))
    println(a.get(4))
}