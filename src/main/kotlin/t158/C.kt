package t158

import java.util.*

fun main() {
    val pwd = mutableListOf<String>()
    with(Scanner(System.`in`)) {
        for (i in 0 until nextLine().toInt()) {
            val command = nextLine()
            when {
                command.startsWith("pwd") -> println(
                    pwd.joinToString(
                        "/",
                        "/",
                        "/"
                    ).let { if (it == "//") "/" else it })
                else -> {
                    var dirs = command.split(" ")[1].split("/")
                    if (dirs.first() == "") {
                        pwd.clear()
                        dirs = dirs.drop(1)
                    }
                    for (d in dirs) {
                        when (d) {
                            ".." -> pwd.removeAt(pwd.lastIndex)
                            else -> pwd.add(d)
                        }
                    }
                }
            }
        }
    }
}