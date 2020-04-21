package jalg.chapter5

import java.util.*

class Alphabet(data: Array<String>) {
    private var alphabet: CharArray
    private var invert = HashMap<Char, Int>()

    init {
        val uniqueChars = TreeSet<Char>()
        for (e in data) {
            uniqueChars.add(e[0])
        }
        alphabet = CharArray(uniqueChars.size)
        uniqueChars.withIndex().forEach { (i, e) ->
            alphabet[i] = e
            invert[e] = i
        }
    }

    fun toChar(index: Int) = alphabet[index]

    fun toIndex(char: Char) = invert[char]!!

    fun radix() = alphabet.size
}