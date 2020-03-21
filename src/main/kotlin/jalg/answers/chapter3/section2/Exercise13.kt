package jalg.answers.chapter3.section2

class Exercise13<K : Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var left: Node<K, V>?, var right: Node<K, V>?)

    private var root: Node<K, V>? = null

    fun get(k: K): V? {
        var cp = root
        while (cp != null && cp.key != k)
            cp = if (cp.key < k) cp.right else cp.left
        return cp?.value
    }

    fun put(k: K, v: V) {
        if (root == null) {
            root = Node(k, v, null, null)
            return
        }
        var cp = root
        while (cp != null) {
            if (cp.key > k) {
                if (cp.left == null) {
                    cp.left = Node(k, v, null, null)
                    break
                } else {
                    cp = cp.left
                    continue
                }
            }
            if (cp.key < k) {
                if (cp.right == null) {
                    cp.right = Node(k, v, null, null)
                    break
                } else {
                    cp = cp.right
                    continue
                }
            }
            if (cp.key == k) {
                cp.value = v
                break
            }
        }
    }
}

fun main() {
    val a = Exercise13<Int, String>()
    a.put(4, "5")
    a.put(3, "6")
    println(a.get(4))
    println(a.get(3))
    println(a.get(3))
}