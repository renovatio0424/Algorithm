package programmers.example


fun main() {
    val s = "a2bAbAba  sdasdCC CCCCcde "
    val result = solution(s)
    println(result)
}

fun solution(s: String): String {
    return makeWordArr(s)
        .map {
            it.lowercase()
        }.map {
            if (isFirstAlphabet(it)) {
                convertCapital(it)
            } else {
                it
            }
        }.reduce { acc, word -> "$acc $word" }
}

fun makeWordArr(s: String): List<String> {
    return s.split(" ")
}

fun convertCapital(word: String): String {
    return word.replaceFirstChar { it.uppercaseChar() }
}

fun isFirstAlphabet(word: String): Boolean {
    return word.isNotBlank() && (word[0] in 'a'..'z' || word[0] in 'A'..'Z')
}
