import java.util.*

object KaratsubaMultiplication {
    private var scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter two numbers to calculate the product: ")
        /*var x = scanner.next()
        var y = scanner.next()*/
        //todo: 8 bit = 1.683573e+15
        /*var x = "31415926"
        var y = "53589793"*/
        //todo: 16 bit = 7.491524886E30
        var x = "3141592653589793"
        var y = "2384626433832795"
        //todo: 32 bit = 9.060972639E61
        /*var x = "31415926535897932384626433832795"
        var y = "02884197169399375105820974944592"*/
        //todo: 64 bit = 8.539734223E126
        /*var x = "3141592653589793238462643383279502884197169399375105820974944592"
        var y = "2718281828459045235360287471352662497757247093699959574966967627"*/
        print(karatMult(x, y))
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
            //todo: add strings
            var z1 = multByTens(x.length.toString(), karatMult(a, c)).toLong()
            var z2 = multByTens(nHalf.toString(), (karatMult(a, d).toLong() + karatMult(b, c).toLong()).toString()).toLong()
            var z3 = karatMult(b, d).toLong()
            return (z1 + z2 + z3).toString()
        }
    }

    fun multByTens(tens: String, n: String): String {
        var result = n
        var i = tens.toInt()
        while(i > 0){
            result += "0"
            i--
        }
        return result
    }
}