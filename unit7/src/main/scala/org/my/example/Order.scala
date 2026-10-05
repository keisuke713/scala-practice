package my.example

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