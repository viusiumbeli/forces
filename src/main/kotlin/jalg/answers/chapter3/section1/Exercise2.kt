package jalg.answers.chapter3.section1

class Exercise2(len: Int) {
    private val keys = IntArray(len)
    private val values = arrayOfNulls<String>(len)
    var n = 0

    fun put(key: Int, value: String?) {
        if (value == null) {
            delete(key)
        }

        for (i in 0 until n)
            if (keys[i] == key) {
                values[i] = value
                return
            }

        keys[n] = key
        values[n++] = value

    }

    fun get(key: Int): String? {
        for (i in 0 until n)
            if (keys[i] == key)
                return values[i]
        return null
    }

    fun delete(key: Int) {
        for (i in 0 until n) {
            if (keys[i] == key) {
                keys[i] = keys[--n]
                values[i] = values[n]
                return
            }
        }
    }

    fun contains(key: Int) = get(key) == null

    fun isEmpty() = n == 0

    fun size() = n - 1

    fun min(): Int? {
        if (isEmpty())
            return null

        var minK = keys[0]
        for (i in 0 until n)
            if (minK > keys[i])
                minK = keys[i]

        return minK
    }

    fun max(): Int? {
        if (isEmpty())
            return null

        var maxK = keys[0]
        for (i in 0 until n)
            if (maxK < keys[i])
                maxK = keys[i]
        return maxK
    }

    fun floor(key: Int): Int? {
        if (isEmpty())
            return null

        var less = -1
        for (i in 0 until n)
            if (keys[i] < key) {
                less = i
                break
            }

        if (less == -1)
            return null

        var floor = keys[less]
        for (i in less until n)
            if (key > keys[i] && key - keys[i] < key - floor)
                floor = keys[i]
        return floor
    }

    fun ceiling(key: Int): Int? {
        if (isEmpty())
            return null

        var more = -1
        for (i in 0 until n)
            if (keys[i] > key) {
                more = i
                break
            }

        if (more == -1)
            return null

        var ceil = keys[more]
        for (i in more until n)
            if (key < keys[i] && keys[i] - key < ceil - key)
                ceil = keys[i]
        return ceil
    }

    fun rank(key: Int): Int {
        var rank = 0
        for (i in 0 until n)
            if (key > keys[i])
                rank++
        return rank
    }

    fun select(rank: Int) = keys[rank]

    fun deleteMin() {
        val minI = min()
        if (minI != null)
            delete(minI)
    }

    fun deleteMax() {
        val maxI = max()
        if (maxI != null)
            delete(maxI)
    }
}

fun main() {
    val a = Exercise2(4)
    a.put(3, "5")
    println(a.max())
    println(a.min())
}