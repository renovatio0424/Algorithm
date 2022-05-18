package programmers.kakao21_internship

fun main() {
    val s = "one4seveneight"
    val result = solution(s)
    println(result)
}

fun solution(s: String): Int {
    var result = s

    val numberWordMap = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    numberWordMap.forEach { (word, number) -> result = convertWordToNumber(result, word, number) }

    return result.toInt()
}

val convertWordToNumber = { s: String, word: String, number: Int ->
    s.replace(word, number.toString())
}
