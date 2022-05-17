package backjoon.dfs

import java.util.*

var count = 0
val nextPositionArr = arrayOf(
    Pair(1, 0),
    Pair(-1, 0),
    Pair(0, 1),
    Pair(0, -1)
)

fun main() {
    val scanner = Scanner(System.`in`)
    val t = scanner.nextInt()
    scanner.nextLine()

    val answerList = arrayListOf<Int>()

    repeat(t) {
        val (m, n, cabbageArr) = initTestConditions(scanner)

        repeat(m) { x ->
            repeat(n) { y ->
                if (cabbageArr[y][x]) {
                    countCabbageBlock(x, y, cabbageArr)
                    count++
                }
            }
        }

        answerList.add(count)
    }

    answerList.forEach { println(it) }
}

private fun initTestConditions(scanner: Scanner): Triple<Int, Int, Array<BooleanArray>> {
    val inputLine = scanner.nextLine()
    val inputList = inputLine.split(" ")
    val m = inputList[0].toInt()
    val n = inputList[1].toInt()
    val k = inputList[2].toInt()

    val cabbageArr = Array(n) { BooleanArray(m) }
    count = 0

    repeat(k) {
        val input = scanner.nextLine()
        val inputs = input.split(" ")

        cabbageArr[inputs[1].toInt()][inputs[0].toInt()] = true
    }
    return Triple(m, n, cabbageArr)
}

private fun countCabbageBlock(x: Int, y: Int, cabbageArr: Array<BooleanArray>) {
    if (cabbageArr[y][x].not()) return

    cabbageArr[y][x] = false

    nextPositionArr.forEach { (nextX, nextY) ->
        val moveX = x + nextX
        val moveY = y + nextY

        if (0 <= moveX && moveX < cabbageArr[y].size && 0 <= moveY && moveY < cabbageArr.size) {
            countCabbageBlock(moveX, moveY, cabbageArr)
        }
    }
}
