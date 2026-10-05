import my.example._
import java.util.Currency

object Main extends App {
    val GBP = Currency.getInstance("GBP")
    val USD = Currency.getInstance("USD")
    val EUR = Currency.getInstance("EUR")

    val money1 = Money(100, GBP)
    val money2 = Money(200, GBP)

    import Money.numeric._
    println(s"money1 + money2 = ${money1 + money2}")
}

class A {
    import A._
    def test(implicit n: Int): String = n.toString
}

object A {
    implicit val n: Int = 42
}