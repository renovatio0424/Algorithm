package programmers.sort

import java.lang.Integer.max

fun main() {
    val citations: IntArray = intArrayOf(3, 0, 6, 1, 5)
    val result: Int = solution(citations)
    println(result)
}

fun solution(citations: IntArray): Int {
    citations.sort()
    val maxCitationCount = citations.last()

    var maxHIndex = -1

    for (index in maxCitationCount downTo 0) {
        if (isHIndex(citations, index)) {
            maxHIndex = max(maxHIndex, index)
        }
    }

    return maxHIndex
}

fun isHIndex(citations: IntArray, index: Int): Boolean {
    val citationCount = citations.count { it >= index }
    val underCount = citations.size - citationCount

    return index in underCount..citationCount
}
