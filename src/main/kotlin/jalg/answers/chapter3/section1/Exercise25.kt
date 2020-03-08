package jalg.answers.chapter3.section1

class Exercise25(len: Int) {
    val a = Array<Item?>(len) { null }
    var n = 0
    var lastItem: Item? = null

    fun get(key: Int): String? {
        if (lastItem?.key == key) {
            return lastItem!!.value
        }

        for (i in 0 until n)
            if (a[i]?.key == key) {
                lastItem = a[i]
                return lastItem!!.value
            }

        return null
    }

    fun contains(key: Int) = get(key) == null

    fun put(key: Int, value: String?) {
        if (value == null) {
            delete(key)
        }

        if (lastItem?.key == key) {
            lastItem!!.value = value!!
            return
        }

        a[n] = Item(key, value!!)
        lastItem = a[n++]
    }

    private fun delete(key: Int) {
        if (lastItem?.key == key) {
            lastItem = null
        }

        for (i in 0 until n)
            if (a[i]?.key == key) {
                a[i] = a[--n]
                a[n] = null
                return
            }
    }

    data class Item(val key: Int, var value: String)
}

fun main() {
    val a= Exercise25(4)
    a.put(4,"5")
    a.put(3,"6")
    a.put(7,"2")
    a.put(8,"1")
    println(a.get(7))
}