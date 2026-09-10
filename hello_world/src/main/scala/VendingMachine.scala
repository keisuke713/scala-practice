class VendingMachine {
    var chocolateBar = 0
    var granolaBar = 0
    var totalMoney = 0.0

    def buy(product: String, money: Double): String =
        if (!isProductAvailable(product))
            s"sorry! $product not available"
        else if (!isMoneyEnough(product, money))
            s"please, insert more money"
        else completeRequest(product, money)

    def isProductAvailable(product: String): Boolean = {
        val quontity = {
            if (product == "chocolate") chocolateBar
            else if (product == "granola") granolaBar
            else 0
        }
        quontity > 0
    }

    def isMoneyEnough(product: String, money: Double): Boolean = {
        val cost = if (product == "chocolate") 1.5 else 1
        return cost <= money
    }

    def completeRequest(product: String, money: Double): String = {
        collectMoney(money)
        releaseProduct(product)
        s"There you go! have a $product bar!"
    }

    def collectMoney(money: Double) = totalMoney += money

    def releaseProduct(product: String) =
        if (product == "chocolate") chocolateBar -= 1
        else granolaBar -= 1

    def addChocolateBar(amount: Int) = chocolateBar += amount
    def addGranolaBar(amount: Int) = granolaBar += amount
}