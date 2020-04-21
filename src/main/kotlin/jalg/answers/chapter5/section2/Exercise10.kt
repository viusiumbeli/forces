package jalg.answers.chapter5.section2

class Exercise10<E> {
    class Node<E>(val key: Char) {
        var value: E? = null
        var left: Node<E>? = null
        var mid: Node<E>? = null
        var right: Node<E>? = null
        var size = 0
    }

    var root: Node<E>? = null

    fun put(key: String, value: E) {
        root = put(root, key, value, 0, true)
    }

    private fun put(node: Node<E>?, key: String, value: E, d: Int, isNewKey: Boolean): Node<E> {
        var cn = node
        if (cn == null) {
            cn = Node(key[d])
        }
        if (key.length - 1 == d) {
            cn.value = value
            return cn
        }
        val c = key[d]
        when {
            c < cn.key -> cn.left = put(cn.left, key, value, d, isNewKey)
            c > cn.key -> cn.right = put(cn.right, key, value, d, isNewKey)
            else -> cn.mid = put(cn.mid, key, value, d + 1, isNewKey)
        }
        if (isNewKey){
            cn.size++
        }
        return cn
    }

    fun size() = size(root)

    private fun size(node: Node<E>?) = node?.size ?: 0
}

fun main() {
    val a = Exercise10<Int>()
    a.put("abc", 1)
    a.put("asdf", 2)
    a.put("asdff", 3)
    a.put("as", 4)
    a.put("bvc", 5)
    println("size = ${a.size()}")
}