object Main extends App {
    println("Hi Kei! Hello, World!")
    // val currency: Currency = CAD
    // val hoge = currency match {
    //     case USD => 1
    //     case GBP => 0.744
    //     case EUR => 0.848
    // }
    // println(s"currency: ${hoge}")

    val value = 100
    val price = value match {
        case n: Int if n < 50 => n
        case n: Int if n < 100 => n * 0.9
        case n => n * 0.85
    }
    println(s"result: $price")
}

sealed trait Currency

object USD extends Currency
object GBP extends Currency
object EUR extends Currency
object CAD extends Currency