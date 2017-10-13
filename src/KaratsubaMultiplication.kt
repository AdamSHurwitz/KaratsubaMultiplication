import java.util.*

object KaratsubaMultiplication {
    @JvmStatic
    fun main(args: Array<String>) {
        //solution = 8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184
        var x = "3141592653589793238462643383279502884197169399375105820974944592"
        var y = "2718281828459045235360287471352662497757247093699959574966967627"
        println(karatMult(x, y))
    }

    private fun karatMult(x: String, y: String): String {

        var nHalf = (x.length / 2.0).toInt()

        var a = x.substring(0, (x.length / 2.0).toInt())
        var b = x.substring(x.length / 2)
        var c = y.substring(0, y.length / 2.0.toInt())
        var d = y.substring(y.length / 2)

        if (x.length == 1 && y.length == 1) {
            return Math.multiplyExact(x.toInt(), y.toInt()).toString()
        } else {
            var z1 = multByTens(x.length.toString(), karatMult(a, c))
            var z2 = multByTens(nHalf.toString(), add(karatMult(a, d), karatMult(b, c)))
            var z3 = karatMult(b, d)
            return add(add(z1, z2), z3)
        }
    }

    fun multByTens(tens: String, n: String): String {
        var result = n
        var i = tens.toInt()
        while (i > 0) {
            result += "0"
            i--
        }
        return result
    }

    fun add(n1: String, n2: String): String {
        var result = ""
        var carryOver = 0
        var i = n1.length
        var j = n2.length
        while (i > 0 && j > 0) {
            var n1 = n1.substring(i - 1, i).toInt()
            var n2 = n2.substring(j - 1, j).toInt()
            var sum = carryOver + n1 + n2
            if (sum >= 10) {
                result = (sum - 10).toString() + result
                carryOver = 1
            } else {
                result = sum.toString() + result
                carryOver = 0
            }
            i--
            j--
        }

        while (i > 0){
            var n1 = n1.substring(i - 1, i).toInt()
            var sum = carryOver + n1
            if (sum >= 10) {
                result = (sum - 10).toString() + result
                carryOver = 1
            } else {
                result = sum.toString() + result
                carryOver = 0
            }
            i--
        }
        while (j > 0){
            var n2 = n2.substring(j - 1, j).toInt()
            var sum = carryOver + n2
            if (sum >= 10) {
                result = (sum - 10).toString() + result
                carryOver = 1
            } else {
                result = sum.toString() + result
                carryOver = 0
            }
            j--
        }

        if (carryOver > 0){
            return carryOver.toString() + result
        } else {
            return result
        }

    }
}