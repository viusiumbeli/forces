package train.t1292

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val q = sc.nextInt()

    val road = Array(2) { Array(n) { 0 } }

    var barricadesFull = 0
    for (i in 1..q) {
        val x = sc.nextInt() - 1
        val y = sc.nextInt() - 1

        road[x][y] = 1 - road[x][y]

        var barricadeCell = 0
        for (j in -1..1) {
            if (y + j < 0 || y + j >= n) continue
            if (road[1 - x][y + j] == 1) barricadeCell++
        }

        barricadesFull += barricadeCell * if (road[x][y] == 0) -1 else 1
        println(
            if (barricadesFull == 0) {
                "YES"
            } else {
                "NO"
            }

        )
    }

}

/*
5 3
1 5
2 4
1 5
 */