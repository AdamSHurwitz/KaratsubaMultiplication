import java.util.*

object KaratsubaMultiplication {
    private var scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter two numbers to calculate the product: ")
        karatMult(scanner.next(), scanner.next())
    }

    private fun karatMult(nOne: String, nTwo: String): Long {
        var a = nOne.substring(0, nOne.length/2)
        var b = nOne.substring(nOne.length/2, nOne.length)
        var c = nTwo.substring(0, nTwo.length/2)
        var d = nTwo.substring(nTwo.length/2, nTwo.length)
        println(a + " " + b)
        println(c + " " + d)
        return 0
    }
}