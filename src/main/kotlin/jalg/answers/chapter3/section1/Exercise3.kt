package jalg.answers.chapter3.section1

class Exercise3 {
    var first: Node? = null
    var size = 0

    fun put(key: Int, value: String?) {
        if (value == null) {
            delete(key)
        }
        value!!

        var cn = first
        while (cn != null) {
            if (cn.key == key) {
                cn.value = value
                return
            }
            cn = cn.next
        }

        first = Node(key, value, first)
        size++
    }

    fun get(key: Int): String? {
        var cn = first
        while (cn != null) {
            if (cn.key == key)
                return cn.value
            cn = cn.next
        }
        return null
    }

    fun delete(key: Int) {
        if (first?.key == key) {
            first = first!!.next
            return
        }

        var cn = first
        while (cn != null) {
            if (cn.next != null && cn.next!!.key == key) {
                cn.next = cn.next!!.next
                size--
                return
            }
            cn = cn.next
        }
    }

    fun contains(key: Int): Boolean {
        var cn = first
        while (cn != null) {
            if (cn.key == key)
                return true
            cn = cn.next
        }
        return false
    }

    fun isEmpty() = size == 0

    fun size() = size

    fun min(): Int? {
        if (isEmpty())
            return null

        var cn = first
        var mink = first!!.key
        while (cn != null) {
            if (cn.key < mink)
                mink = cn.key
            cn = cn.next
        }
        return mink
    }

    fun max(): Int? {
        if (isEmpty())
            return null

        var cn = first
        var maxk = first!!.key
        while (cn != null) {
            if (cn.key > maxk)
                maxk = cn.key
            cn = cn.next
        }
        return maxk
    }

    fun rank(key: Int): Int {
        var cn = first
        var rank = 0
        while (cn != null) {
            if (key > cn.key)
                rank++
            cn = cn.next
        }
        return rank
    }

    fun select(rank: Int): Int? {
        var cn = first
        var count = 0
        while (cn != null) {
            if (++count == rank)
                return cn.key
            cn = cn.next
        }
        return null
    }

    fun deleteMin() {
        val min = min()
        if (min != null) {
            delete(min)
        }
    }

    fun deleteMax() {
        val max = max()
        if (max != null) {
            delete(max)
        }
    }

    data class Node(val key: Int, var value: String, var next: Node?)
}

fun main() {
    val a = Exercise3()
    a.put(4, "5")
    a.put(3, "5")
    a.delete(4)
    println(a.min())
    println(a.max())
}