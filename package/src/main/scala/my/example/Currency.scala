sealed trait Currency {
    def unit: String
}

object USD extends Currency {
    def unit = "dollar"
}
object CAD extends Currency {
    def unit = "dollar"
}
object EUR extends Currency {
    def unit = "euro"
}