package my.example

case class NutritionFacts(
    totalFat: Double
    saturatedFat: Double
    sugars: Double
    salt: Double
)

class Drink(
    name: String,
    brand: String,
    size: Double

    def loadNutritionFacts(): NutritionFacts = ???
)

object Drink {
    def unapply(drink: Drink): Option[(Double, Double)] = {
        val nutritionFacts = drink.loadNutritionFacts()
        Some((nutritionFacts.saturatedFat, nutritionFacts.sugars))
    }
}

sealed trait Label
case object LowSaturatedFatAndSuger extends Label
case object LowSaturatedFat extends Label
case object LowSuger extends Label
case object HighSaturatedFatAndSuger extends Label

val saturatedFatThreshold: Double = 5.0
val sugarThreshold: Double = 4.0

def analyze(drink: Drink): Label = drink match {
    case Drink(fat, sugar)
        if fat < fatThreshold && sgar < sugarThreshold => LowSaturatedFatAndSugar
    case Drink(fat, _) if fat < fatThreshld => LowSaturatedFat
    case Drink(_, sugar) if sugar < sugarThreshold => LowSugar
    case _ => HighSaturatedFatAndSugar
}

// def analyze(drink: Drink): Lable = drink.loadNutritionFacts() match {
//     case NutritionFacts(_, saturatedFat, suger, _)
//         if saturatedFat < saturatedFatThreshold && suger < sugarThreshold => LowSaturatedFatAndSuger
//     case NutritionFacts(_, saturatedFat, _, _)
//         if saturatedFat < saturatedFatThreshold => LowSaturatedFat
//     case NutritionFacts(_, _, sugar, _)
//         if suger < sugarThreshold => LowSugar
//     case _ => HighSaturatedFatAndSuger
// }