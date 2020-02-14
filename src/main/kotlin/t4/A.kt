package t4

import java.util.*

fun main() = println(Scanner(System.`in`).nextInt().takeIf { it % 2 != 0 || it == 2 }?.let { "NO" } ?: "YES")