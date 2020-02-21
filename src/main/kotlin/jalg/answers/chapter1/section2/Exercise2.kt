package jalg.answers.chapter1.section2

import edu.princeton.cs.algs4.Interval1D
import edu.princeton.cs.algs4.StdRandom


fun main() {
    val n = 100
    val intervals: Array<Interval1D> =
        Array(n) { val min = StdRandom.uniform(); Interval1D(min, min + StdRandom.uniform()) }
    sortIntervals(intervals, 0, intervals.lastIndex)
    println(countIntersections(intervals))
}

fun countIntersections(intervals: Array<Interval1D>): Int {
    var res = 0
    if (intervals.lastIndex < 2)
        return res
    for (i in 1..intervals.lastIndex) {
        if (intervals[i - 1].max() > intervals[i].min())
            res++
    }
    return res
}

fun sortIntervals(intervals: Array<Interval1D>, s: Int, e: Int) {
    val mid = (s + e) / 2
    var l = s
    var h = e
    val opor = intervals[mid]
    while (l <= h) {
        while (intervals[l].min() < opor.min()) l++
        while (intervals[h].min() > opor.min()) h--
        if (l <= h) {
            val t = intervals[l]
            intervals[l] = intervals[h]
            intervals[h] = t
            l++
            h--
        }
    }
    if (l < e) sortIntervals(intervals, l, e)
    if (s < h) sortIntervals(intervals, s, h)
}