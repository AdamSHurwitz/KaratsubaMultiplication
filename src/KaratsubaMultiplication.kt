import java.util.*

object KaratsubaMultiplication {
    private var scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter two numbers to calculate the product: ")
        /*var x = scanner.next()
        var y = scanner.next()*/
        //todo: 4 bit = 7,006,652 | 6,912
        /*var x = "1234"
        var y = "5678"*/
        //todo: 8 bit = 1.683573e+15
        /*var x = "31415926"
        var y = "53589793"*/
        //todo: 16 bit = 7.491524886E30
        /*var x = "3141592653589793"
        var y = "2384626433832795"*/
        //todo: 32 bit = 9.060972639E61
        /*var x = "31415926535897932384626433832795"
        var y = "02884197169399375105820974944592"*/
        //todo: 64 bit = 8.539734223E126
        var x = "3141592653589793238462643383279502884197169399375105820974944592"
        var y = "2718281828459045235360287471352662497757247093699959574966967627"
        println(add("99999999999", "99999999"))
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