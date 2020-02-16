package t158

import java.util.*
import kotlin.math.min

fun main() {
    with(Scanner(System.`in`)) {
        val data = Array(4) { 0 }
        for (i in 0 until nextInt()) {
            data[nextInt() - 1]++
        }
        var cars = data[3]
        cars += data[2]
        data[0] -= min(data[2], data[0])
        if (data[1] % 2 != 0) {
            cars++
            data[0] -= min(2, data[0])
        }
        cars += data[1] / 2
        if (data[0] % 4 != 0) cars++
        cars += data[0] / 4
        println(cars)
    }
}