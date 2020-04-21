package jalg.chapter5

import java.util.*

open class TrieST<E> {
    class Node<E> {
        var element: E? = null
        val links = Array<Node<E>?>(26) { null }
    }

    private var size = 0

    var root = Node<E>()

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

    fun contains(key: String) = get(key) != null

    fun isEmpty(): Boolean {
        for (e in root.links)
            if (e == null)
                return true
        return false
    }

    fun keys(): Iterable<String> {
        val queue = LinkedList<String>()
        keys(root, queue, "")
        return queue
    }

    private fun keys(node: Node<E>, queue: LinkedList<String>, key: String) {
        if (node.element != null) {
            queue.push(key)
        }
        for ((i, e) in node.links.withIndex()) {
            if (e != null) {
                keys(e, queue, key + (i + 97).toChar())
            }
        }
    }

    fun longestPrefixOf(s: String): String? {
        val longestPrefixOf = longestPrefixOf(root, s, 0)
        if (longestPrefixOf != null) {
            return s.substring(0, longestPrefixOf)
        }
        return null
    }

    private fun longestPrefixOf(node: Node<E>, s: String, d: Int): Int? {
        var currKey: Int? = null
        if (node.element != null) {
            currKey = d
        }
        if (d == s.length) {
            return currKey
        }
        return if (node.links[s[d].toInt() - 97] != null)
            longestPrefixOf(node.links[s[d].toInt() - 97]!!, s, d + 1)
        else currKey
    }

    fun keysWithPrefix(prefix: String): Iterable<String> {
        val queue = LinkedList<String>()
        keysWithPrefix(queue, root, prefix, "", 0)
        return queue
    }

    private fun keysWithPrefix(queue: LinkedList<String>, node: Node<E>, prefix: String, key: String, d: Int) {
        if (key.length >= prefix.length && node.element != null) {
            queue.push(key)
        }
        for ((i, e) in node.links.withIndex()) {
            if (e != null && (d >= prefix.length || prefix[d] == '.' || i == prefix[d].toInt() - 97)) {
                keysWithPrefix(queue, e, prefix, key + (i + 97).toChar(), d + 1)
            }
        }
    }

    fun keysThatMatch(prefix: String): Iterable<String> {
        val queue = LinkedList<String>()
        keysThatMatch(queue, root, prefix, "", 0)
        return queue
    }

    private fun keysThatMatch(queue: LinkedList<String>, node: Node<E>, prefix: String, key: String, d: Int) {
        if (d == prefix.length && node.element != null) {
            queue.push(key)
            return
        }
        for ((i, e) in node.links.withIndex()) {
            if (e != null && (prefix[d] == '.' || prefix[d] == (i + 97).toChar())) {
                keysThatMatch(queue, e, prefix, key + (i + 97).toChar(), d + 1)
            }
        }
    }
}

fun main() {
    val a = TrieST<Int>()
    a.put("abc", 1)
    println(a.get("asfd"))
    println(a.get("abc"))
    a.put("asdf", 2)
    println(a.get("asdf"))
    a.keys().forEach { println(it) }
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