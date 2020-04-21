package jalg.chapter5

import java.util.*

class TST<E> {
    class Node<E>(val key: Char) {
        var value: E? = null
        var left: Node<E>? = null
        var mid: Node<E>? = null
        var right: Node<E>? = null
    }

    var root: Node<E>? = null
    var size = 0

    fun put(key: String, value: E) {
        root = put(root, key, value, 0)
    }

    private fun put(node: Node<E>?, key: String, value: E, d: Int): Node<E> {
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
            c < cn.key -> cn.left = put(cn.left, key, value, d)
            c > cn.key -> cn.right = put(cn.right, key, value, d)
            else -> cn.mid = put(cn.mid, key, value, d + 1)
        }
        return cn
    }

    fun get(key: String): E? {
        return get(root, key, 0)
    }

    private fun get(node: Node<E>?, key: String, d: Int): E? {
        if (node == null) {
            return null
        }

        if (key.length - 1 == d) {
            return node.value
        }

        val c = key[d]
        return when {
            c < node.key -> get(node.left, key, d)
            c > node.key -> get(node.right, key, d)
            else -> get(node.mid, key, d + 1)
        }
    }

    fun keys(): Iterable<String> {
        val queue = LinkedList<String>()
        keys(queue, root, "")
        return queue
    }

    private fun keys(queue: LinkedList<String>, node: Node<E>?, key: String) {
        if (node == null) {
            return
        }
        if (node.value != null) {
            queue.push(key + node.key)
        }
        keys(queue, node.left, key)
        keys(queue, node.right, key)
        keys(queue, node.mid, key + node.key)
    }

    fun longestPrefixOf(key: String): String? {
        val longestPrefixOf = longestPrefixOf(root, key, 0)
        if (longestPrefixOf == null) {
            return null
        }
        return key.substring(0, longestPrefixOf + 1)
    }

    private fun longestPrefixOf(node: Node<E>?, key: String, d: Int): Int? {
        if (node == null) {
            return null
        }
        if (key.length - 1 == d && node.value != null) {
            return d
        }
        if (key.length - 1 == d) {
            return null
        }
        var curr: Int? = null
        if (node.value != null) {
            curr = d
        }
        val longest = when {
            key[d] < node.key -> longestPrefixOf(node.left, key, d)
            key[d] > node.key -> longestPrefixOf(node.right, key, d)
            else -> longestPrefixOf(node.mid, key, d + 1)

        }
        return longest ?: curr
    }

    fun keysWithPrefix(prefix: String): Iterable<String> {
        val queue = LinkedList<String>()
        keysWithPrefix(queue, root, prefix, "", 0)
        return queue
    }

    private fun keysWithPrefix(queue: LinkedList<String>, node: Node<E>?, prefix: String, key: String, d: Int) {
        if (node == null) {
            return
        }
        if (d >= prefix.lastIndex && node.value != null) {
            queue.push(key + node.key)
        }

        if (d > prefix.lastIndex || node.key > prefix[d] || prefix[d] == '.') {
            keysWithPrefix(queue, node.left, prefix, key, d)
        }
        if (d > prefix.lastIndex || node.key < prefix[d] || prefix[d] == '.') {
            keysWithPrefix(queue, node.right, prefix, key, d)
        }
        if (d > prefix.lastIndex || node.key == prefix[d] || prefix[d] == '.') {
            keysWithPrefix(queue, node.mid, prefix, key + node.key, d + 1)
        }
    }

    fun keysThatMatch(prefix: String): Iterable<String> {
        val queue = LinkedList<String>()
        keysThatMatch(queue, root, prefix, "", 0)
        return queue
    }


    private fun keysThatMatch(queue: LinkedList<String>, node: Node<E>?, prefix: String, key: String, d: Int) {
        if (node == null) {
            return
        }
        if (d == prefix.lastIndex && node.value != null) {
            queue.push(key + node.key)
            return
        }

        if (d == prefix.lastIndex) {
            return
        }

        if (node.key > prefix[d] || prefix[d] == '.') {
            keysThatMatch(queue, node.left, prefix, key, d)
        }
        if (node.key < prefix[d] || prefix[d] == '.') {
            keysThatMatch(queue, node.right, prefix, key, d)
        }
        if (node.key == prefix[d] || prefix[d] == '.') {
            keysThatMatch(queue, node.mid, prefix, key + node.key, d + 1)
        }
    }

}

fun main() {
    val a = TST<Int>()
    a.put("abc", 1)
    println(a.get("asfd"))
    println(a.get("abc"))
    a.put("asdf", 2)
    println(a.get("asdf"))
    a.keys().forEach { println(it) }
    println("----")
    println(a.longestPrefixOf("asdffff"))
    println(a.longestPrefixOf("asd"))
    println(a.longestPrefixOf("abc"))
    println("----")
    a.keysWithPrefix("a").forEach { println(it) }
    a.keysWithPrefix("as").forEach { println(it) }
    a.keysWithPrefix("asf").forEach { println(it) }
    a.keysWithPrefix(".").forEach { println(it) }
    println("----")
    a.keysThatMatch("asdf").forEach { println(it) }
    a.keysThatMatch(".bc").forEach { println(it) }

}