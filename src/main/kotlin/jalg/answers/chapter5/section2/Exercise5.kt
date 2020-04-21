package jalg.answers.chapter5.section2

import java.util.*

class Exercise51<E> {
    class Node<E> {
        var element: E? = null
        val links = Array<Node<E>?>(26) { null }
    }

    private var root = Node<E>()

    fun put(key: String, element: E) {
        var curr = root
        for (e in key) {
            val index = e.toInt() - 97
            if (curr.links[index] == null) {
                curr.links[index] = Node()
            }
            curr = curr.links[index]!!
        }
        curr.element = element
    }

    fun get(key: String): E? {
        var curr = root
        for (e in key) {
            if (curr.links[e.toInt() - 97] == null) {
                return null
            }
            curr = curr.links[e.toInt() - 97]!!
        }
        return curr.element
    }

    fun contains(key: String) = get(key) != null

    fun isEmpty(): Boolean {
        for (e in root.links)
            if (e != null)
                return false
        return true
    }
}

fun main() {
    val a = Exercise51<Int>()
    a.put("abc", 1)
    println(a.get("asfd"))
    println(a.get("abc"))
    a.put("asdf", 2)
    println(a.get("asdf"))
}