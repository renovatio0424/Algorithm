package programmers.monthly_code_challenge1

fun main() {
    val n = 4
    val result = solution(n)

    println(result.joinToString(separator = ",", prefix = "[", postfix = "]"))
}

fun solution(n: Int): IntArray {
    return TriangularSnailImp().getTriangularSnail(n)
}

class TriangularSnailImp : TriangularSnail {

    override fun getTriangularSnail(n: Int): IntArray {
        val lastIdx = getLastNumber(n)
        val triangleArr = createTriangleArr(n)

        var point = Pair(0, 0)
        var direction = Direction.Down
        triangleArr[0][0] = 1

        for (number in 2..lastIdx) {
            point = direction.move(point.first, point.second)

            if (disableToMove(point, triangleArr)) {
                point = direction.back(point.first, point.second)
                direction = direction.getNextDirection()
                point = direction.move(point.first, point.second)
            }

            triangleArr[point.second][point.first] = number
        }

        return convertAnswerArr(lastIdx, triangleArr)
    }

    private fun convertAnswerArr(lastIdx: Int, triangleArr: Array<IntArray>): IntArray {
        val answer = IntArray(lastIdx)
        var index = 0
        for (y in triangleArr.indices) {
            for (x in triangleArr.indices) {
                if (triangleArr[y][x] != -1) {
                    answer[index] = triangleArr[y][x]
                    index++
                }
            }
        }
        return answer
    }

    private fun disableToMove(point: Pair<Int, Int>, triangleArr: Array<IntArray>): Boolean {
        return point.second < 0 ||
                point.first < 0 ||
                point.second >= triangleArr.size ||
                point.first >= triangleArr.size ||
                triangleArr[point.second][point.first] != 0
    }

    private fun createTriangleArr(n: Int): Array<IntArray> {
        val arr = Array(n) { IntArray(n) }
        var rowCount = 1
        for (y in arr.indices) {
            for ((count, x) in arr[y].indices.withIndex()) {
                if (count >= rowCount) {
                    arr[y][x] = -1
                }
            }
            rowCount++
        }
        return arr
    }

    private fun getLastNumber(n: Int): Int = n * (n + 1) / 2
}

enum class Direction(private val dx: Int, private val dy: Int) {
    Down(0, 1),
    Right(1, 0),
    LeftTop(-1, -1);

    fun move(x: Int, y: Int): Pair<Int, Int> {
        return Pair(x + dx, y + dy)
    }

    fun back(x: Int, y: Int): Pair<Int, Int> {
        return Pair(x - dx, y - dy)
    }

    fun getNextDirection(): Direction = when (this) {
        Down -> Right
        Right -> LeftTop
        LeftTop -> Down
    }
}

interface TriangularSnail {
    fun getTriangularSnail(n: Int): IntArray
}
