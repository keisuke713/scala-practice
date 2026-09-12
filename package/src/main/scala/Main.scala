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

    val c = new Cat()
    c.eat("cheese")
    c.move(1,2)

    val d = new Dog("hana")
    println(d.name)

    println(USD.unit)
  }
}

object JPN extends Currency {
  def unit = "yen"
}