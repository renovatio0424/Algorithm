package programmers.greedy

fun main() {
    val numbers = arrayOf(1, 2, 3, 4, 6, 7, 8, 0)
    val answer = solution(numbers)
    println(answer)
}

fun solution(numbers: Array<Int>): Int {
    val total = (0..9).reduce { a, b -> a + b }
    val numbersSum = numbers.sum()
    return total - numbersSum
}
