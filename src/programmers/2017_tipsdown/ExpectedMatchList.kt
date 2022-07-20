package programmers.`2017_tipsdown`

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val n = 8
    val a = 2
    val b = 3

    val result = Solution().solution(n, a, b)
    println(result)
}

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var mA: Float = a.toFloat()
        var mB: Float = b.toFloat()
        val total = log(n.toFloat(), 2.toFloat())

        while (answer <= total) {
            if (abs(mA - mB) <= 0) return answer

            mA = ceil(mA.div(2))
            mB = ceil(mB.div(2))

            answer++
        }

        return answer
    }
}