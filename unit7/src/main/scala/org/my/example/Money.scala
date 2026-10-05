package my.example

import java.util.Currency
import scala.util.Try

case class Money(amount: Double, currency: Currency) {
}

object Money {
    implicit val numeric: Numeric[Money] = new Numeric[Money] {
        private val defaultCurrency = Currency.getInstance("USD")

        override def plus(x: Money, y: Money): Money = {
            sameCurrencyOp(x, y)
            x.copy(amount = x.amount + y.amount)
        }

        override def minus(x: Money, y: Money): Money = {
            sameCurrencyOp(x, y)
            x.copy(amount = x.amount - y.amount)
        }

        override def times(x: Money, y: Money): Money = {
            sameCurrencyOp(x, y)
            x.copy(amount = x.amount * y.amount)
        }

        override def negate(x: Money): Money =
            x.copy(amount = - x.amount)

        override def fromInt(x: Int): Money = Money(x, defaultCurrency)

        override def toInt(x: Money): Int = x.amount.toInt

        override def toLong(x: Money): Long = x.amount.toLong

        override def toFloat(x: Money): Float = x.amount.toFloat

        override def toDouble(x: Money): Double = x.amount

        override def compare(x: Money, y: Money): Int = {
            sameCurrencyOp(x, y)
            x.amount.compare(y.amount)
        }

        private def sameCurrencyOp(x: Money, y: Money) =
            require(x.currency == y.currency, "Monetary amounts needs to have the same currency")

        override def parseString(text: String): Option[Money] = {
            text.split("\\s+").toList match {
                case amountText :: currencyCode :: _ =>
                val parsedMoney = for {
                    amount <- Try(amountText.toDouble)
                    currency <- Try(Currency.getInstance(currencyCode))
                } yield Money(amount, currency)
                parsedMoney.toOption
                case _ => None  
            }
        }
    }
}