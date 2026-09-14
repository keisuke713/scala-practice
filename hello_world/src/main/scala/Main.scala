object Main extends App {
    // println("Hi Kei! Hello, World!")
    // val currency: Currency = CAD
    // val hoge = currency match {
    //     case USD => 1
    //     case GBP => 0.744
    //     case EUR => 0.848
    //     case CAD => 1.29
    // }
    // println(s"currency: ${hoge}")

    // val value = 100
    // val price = value match {
    //     case n: Int if n < 50 => n
    //     case n: Int if n < 100 => n * 0.9
    //     case n => n * 0.85
    // }
    // println(s"result: $price")
    // println(s"4 + 5 = ${MyCalculator.sum(4, 5)}")

    val transform: PartialFunction[String, String] = {
        case s: String if s.startsWith("a") => s.reverse
        case s: String if s.startsWith("s") => s.toUpperCase()
    }

    val transformv2: PartialFunction[String, String] = {
        case s: String if s.startsWith("k") => s.concat(s)
    }

    val transformv3: PartialFunction[String, String] = {
        case s: String => s
    }

    def transformAndV2(s: String) = transform.orElse(transformv2)(s)
    def transformAndV3(s: String) = transform.orElse(transformv3)(s)

    println(transformAndV2("apple"))
    println(transformAndV2("keisuke"))
    println(transformAndV3("nebashi"))

    try {
        throw new NebashiException("boom")
        42
    } catch {
        case ex: Exception =>
            println(s"ignoring exception $ex. returning zero instead")
            0
    }

    val hge = try {
        val b = "true".toBoolean
        b
    } catch {
        case ex: Exception => false
    }
    println(hge)

    def parseStrToInt: String => Int = { s => 
        try {
            s.toInt
        } catch {
            case _: IllegalArgumentException =>
                s.length()
        }
    }
    println(s"1: ${parseStrToInt("1")}, hoge: ${parseStrToInt("hoge")}")
}

class NebashiException(msg: String) extends Exception(msg)

sealed trait Currency

object USD extends Currency
object GBP extends Currency
object EUR extends Currency
object CAD extends Currency