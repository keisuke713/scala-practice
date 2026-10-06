package my.example

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

def isProductAvailable(productId: Int, quantity: Double): Future[Boolean] = {
    requestAvailability(productId, quantity)
}

private def requestAvailability(productId: Int, quantity: Double): Future[Boolean] = ???

case class Availability(id: Int, quantity: Double)

def trackAvailability(availability: Future[Availability]): Unit =
    availability.onComplete {
        case Success(p) if p.quantity <= 0 => println(s"Product ${p.id} is out of stock")
        case Success(p) => println(s"Product ${p.id} is available with quantity ${p.quantity}")
        case Failure(e) => println(s"Failed to track availability: ${e.getMessage}")
    }

case class User(id: Int) {
    def purchase(userId: Int, selection: ProductSelection): Either[String, Int] = {
        // val userContext = getUserContext(userId)
        implicit val userContext = getUserContext(userId)
        for {
            _ <- validateAddressWithinDistance
            _ <- validateSelection(selection)
            _ <- validateBalance(selection)
        } yield placeOrder(selection)
    }

    private def getUserContext(userId: Int): UserContext = ???

    private def validateBalance(selection: ProductSelection)(implicit userContext: UserContext): Either[String, Double] = ???

    private def validateAddressWithinDistance(implicit userContext: UserContext): Either[String, UserContext] = ???

    private def validateSelection(selection: ProductSelection)(implicit userContext: UserContext): Either[String, ProductSelection] = ???

    private def placeOrder(selection: ProductSelection)(implicit userContext: UserContext): Int = ???

}

case class PersonalDetails(name: String, address: String)
case class Account(balance: Double)
case class UserContext(id: Int, details: PersonalDetails, account: Account)
case class ProductSelection(productsIds: List[Int])
case class Order(id: Int)

object Order {
    implicit val ordering: Ordering[Order] = Ordering.by(_.id)
}