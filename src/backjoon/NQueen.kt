package backjoon

import java.util.*
import javax.swing.text.html.HTML.Attribute.N
import kotlin.math.abs


fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val result = solution(n)
    result.forEach { println(it) }
}

fun solution(n: Int): IntArray {
    val nQueenGame: NQueenGame = NQueenGameImpl(n)

    return nQueenGame.printNQueenColumns()
}

class NQueenGameImpl(private val n: Int) :NQueenGame {
    private val arr: IntArray = IntArray(n)
    private var count: Int = 0

    private fun move(depth: Int) {
        if (depth == n) {
            count++
            return
        }

        for (i in 0 until n) {
            arr[depth] = i

            if (enableToMove(depth)) {
                move(depth + 1)
            }
        }
    }

    private fun enableToMove(column: Int): Boolean {
        for (i in 0 until column) {
            if (arr[column] == arr[i]) {
                return false
            }

            if (abs(column - i) == abs(arr[column] - arr[i])) {
                return false
            }
        }

        return true
    }


    override fun getAllCount(): Int {
        move(0)
        return count
    }

    override fun printNQueenColumns(): IntArray {
        val columnList = mutableListOf<Int>()

        if (n % 6 != 2 && n % 6 != 3) {
            for (i in 1..n / 2) {
                columnList.add(2 * i - 1)
            }
            if (n % 2 == 1) {
                columnList.add(n)
            }
            for (i in 1..n / 2) {
                columnList.add(2 * i)
            }
        } else if (n % 6 == 2) {
            for (i in 1..n / 2) {
                columnList.add(2 * i)
            }
            columnList.add(3)
            columnList.add(1)
            for (i in n / 2 + 2 until n - 1) {
                columnList.add(2 * (i - n / 2 + 1) + 1)
            }
            columnList.add(5)
        } else {
            for (i in 2..n / 2) {
                columnList.add(2 * i)
            }
            columnList.add(2)
            for (i in n / 2 until n - 2) {
                columnList.add((i - n / 2 + 2) * 2 + 1)
            }
            columnList.add(1)
            columnList.add(3)
        }

        return columnList.toIntArray()
    }

}

interface NQueenGame {
    fun getAllCount(): Int
    fun printNQueenColumns(): IntArray
}
