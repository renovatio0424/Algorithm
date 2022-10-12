package programmers.example

import java.math.BigInteger


fun main() {
    val result = solution(100_000)
    println(result)
}

lateinit var memoization: Array<BigInteger>

fun solution(n: Int): Int {
    memoization = Array(n + 1) { BigInteger.ZERO }
    memoization[0] = BigInteger.ZERO
    memoization[1] = BigInteger.ONE
    val answer = fibonazzi(n)
    return (answer.mod(BigInteger.valueOf(1234567))).toInt()
}


fun fibonazzi(n: Int): BigInteger {
    var current = 0

    while (current + 1 != n) {
        val a = memoization[current]
        val b = memoization[current + 1]
        memoization[current + 2] = a.add(b)
        current++
    }
    return memoization[current + 1]
 }
