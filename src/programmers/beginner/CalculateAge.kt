package programmers.beginner


/**
 *
https://school.programmers.co.kr/learn/courses/30/lessons/120820

문제 설명
머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 나이 age가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성해주세요.

제한사항
0 < age ≤ 120
나이는 태어난 연도에 1살이며 1년마다 1씩 증가합니다.

입출력 예
age	result
40	1983
23	2000
 */
fun main() {
    val age = 22
    val result = solution(age)
    println(result)
}

fun solution(age: Int): Int {
    val currentYear: Int = 2022
    return currentYear - age + 1
}