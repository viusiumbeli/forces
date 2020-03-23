package jalg.chapter3

class HashMapLin {
    private val INITIAL_CPASITY = 2
    private var keys = IntArray(INITIAL_CPASITY) { -1 }
    private var values = IntArray(INITIAL_CPASITY) { -1 }
    private var len = INITIAL_CPASITY
    private var size = 0

    fun put(key: Int, value: Int) {
        var hash = hash(key)
        if (keys[hash] == key) {
            values[hash] = value
            return
        }
        while (keys[hash] != -1) {
            hash = ++hash % len
        }
        keys[hash] = key
        values[hash] = value
        size++
        if (size * 2 == len) {
            resize(len * 2)
        }
    }

    private fun resize(newLen: Int) {
        this.len = newLen
        val ck = keys
        val cv = values
        keys = IntArray(len) { -1 }
        values = IntArray(len) { -1 }
        for (i in ck.indices) {
            if (ck[i] != -1) {
                size--
                put(ck[i], cv[i])
            }
        }
    }

    fun get(key: Int): Int? {
        var hash = hash(key)
        while (keys[hash] != key && keys[hash] != -1)
            hash = ++hash % len
        if (keys[hash] == key) {
            return values[hash]
        }
        return null
    }

    fun remove(key: Int) {
        var hash = hash(key)
        while (keys[hash] != key && keys[hash] != -1)
            hash = ++hash % len
        keys[hash] = -1
        values[hash] = -1
        hash = ++hash % len
        while (keys[hash] != -1) {
            val keyToHash = keys[hash]
            val valueToHash = values[hash]
            size--
            put(keyToHash, valueToHash)
            hash = ++hash % len
        }
        if (size * 8 == len) {
            resize(len / 2)
        }
    }

    private fun hash(key: Int): Int {
        var hash = key.hashCode() and 0x7fffffff
        hash %= len
        return hash
    }
}

fun main() {
    val a = HashMapLin()
    a.put(1, 1)
    a.put(2, 2)
    a.put(3, 3)
    a.put(4, 4)
    a.put(5, 5)
    println(a.get(5))
    println(a.get(3))
    a.remove(3)
    println(a.get(3))
    println(a.get(4))
}