package jalg.answers.chapter5.section2

class Exercise8<E> {
    class Node<E> {
        var element: E? = null
        val links = Array<Node<E>?>(26) { null }
    }

    private var size = 0
    private var root = Node<E>()

    fun put(key: String, element: E) {
        root = put(root, key, element, 0)
    }

    private fun put(node: Node<E>?, key: String, element: E, d: Int): Node<E> {
        var nc = node
        if (nc == null) {
            nc = Node()
        }
        if (d == key.length) {
            if (node == null) size++
            nc.element = element
            return nc
        }
        nc.links[key[d].toInt() - 97] = put(nc.links[key[d].toInt() - 97], key, element, d + 1)
        return nc
    }

    fun get(key: String): E? {
        return get(root, key, 0)
    }

    private fun get(node: Node<E>?, key: String, d: Int): E? {
        if (node == null) {
            return null
        }
        if (key.length == d) {
            return node.element
        }
        return get(node.links[key[d].toInt() - 97], key, d + 1)
    }

    fun rank(key: String): Int {
        return rank(root, key, 0, 0)
    }

    private fun rank(node: Node<E>?, key: String, rank: Int, d: Int): Int {
        if (node == null) {
            return 0
        }

        if (key.length == d && node.element != null) {
            return rank + 1
        }

        if (key.length == d) {
            return 0
        }

        if (node.links[key[d].toInt() - 97] == null) {
            return 0
        }
        var cr = rank
        for (e in node.links) {
            when (e) {
                node.links[key[d].toInt() - 97] -> return rank(e, key, cr, d + 1)
                else -> cr += size(e)
            }
        }
        return 0
    }

    fun size() = size(root)

    private fun size(node: Node<E>?): Int {
        if (node == null) {
            return 0
        }
        var s = 0
        if (node.element != null) {
            s++
        }
        for (e in node.links) {
            s += size(e)
        }
        return s
    }

    fun select(rank: Int): String? {
        return select(root, rank)
    }

    private fun select(node: Node<E>?, rank: Int): String? {
        if (node == null) {
            return null
        }
        var cr = rank
        for ((i, e) in node.links.withIndex()) {
            val s = size(e)
            if (cr - s <= 0) {
                return when (val a = select(e, cr)) {
                    null -> (i + 97).toChar().toString()
                    else -> (i + 97).toChar() + a
                }
            } else {
                cr -= s
            }
        }
        return null
    }
}

fun main() {
    val a = Exercise8<Int>()
    a.put("abc", 1)
    println(a.get("asfd"))
    println(a.get("abc"))
    a.put("asdf", 2)
    println(a.get("asdf"))
    println("-----")
    println(a.rank("asdf"))
    println(a.rank("abc"))
    println(a.rank("abd"))
    println("size = ${a.size()}")
    println("select 2=${a.select(2)}")
    println("select 1=${a.select(1)}")
    println("select 0=${a.select(0)}")
    println("select 3=${a.select(3)}")
}