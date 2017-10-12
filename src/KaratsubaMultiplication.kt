import java.util.*

object KaratsubaMultiplication {
    private var scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter two numbers to calculate the product: ")
        var x = scanner.next()
        var y = scanner.next()
        print(karatMult(x, y))
    }

    private fun karatMult(x: String, y: String): String {
        var a = x.substring(0, Math.ceil(x.length / 2.0).toInt())
        var b = x.substring(x.length / 2)
        var c = y.substring(0, Math.ceil(y.length / 2.0).toInt())
        var d = y.substring(y.length / 2)

        if (x.length == 1 && y.length == 1) {
            return Math.multiplyExact(x.toInt(), y.toInt()).toString()
        } else {
            return (multByTens((Math.pow(10.0, x.length.toDouble()).toInt().toString()),
                    karatMult(a, c)).toLong()
                    +
                    multByTens(
                            (Math.pow(10.0, x.length / 2.0).toString()),
                            (karatMult(a, d).toLong() + karatMult(b, c).toLong()).toString())
                            .toLong()
                    + karatMult(b, d).toLong())
                    .toString()
        }
    }

    fun multByTens(tens: String, n: String): String {
        var result = n
        for (i in tens) {
            when(i){
                '.' -> return result
                '0' -> result += i
            }
        }
        return result
    }
}