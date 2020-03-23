package jalg.chapter3

interface SearchTree<K, V> {
    fun size(): Int
    fun isEmpty(): Boolean
    fun get(k: K): V?
    fun contains(k: K): Boolean
    fun put(k: K, v: V)
    fun min(): BST.Node<K, V>?
    fun max(): BST.Node<K, V>?
    fun floor(k: K): K?
    fun ceiling(k: K): K?
    fun select(rank: Int): K?
    fun rank(k: K): Int
    fun deleteMin()
    fun deleteMax()
    fun delete(k: K)
    fun printAll()
    fun keys(): Iterable<BST.Node<K, V>>?
    fun keys(l: K, h: K): Iterable<BST.Node<K, V>>?
}