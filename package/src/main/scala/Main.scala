import my.example.io._
import my.areas.{Circle => C}
import my.example._

// object Main extends App {
//   println("Hello, World!")

//   val p = new Party()
//   p.register(9)
//   val cost = p.cost()
//   println(s"costs for 10 people: $cost")
//   p.cost()

//   val e = new Employee()
//   println(e.name)
// }

object Main {
  def main(args: Array[String]): Unit = {
    println("hello from main object")

    val baby = Person(new Person("keisuke", 30), new Person("asami", 30))
    println(s"${baby.name}")

    val p1 = Person("kei", 30)
    val p2 = Person("yumemi", 25)
    println(s"older is ${Person.isOlder(p1, p2).name}")
  }
}