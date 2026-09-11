import my.example.io._
import my.areas.{Circle => C}
import my.example._

object Main extends App {
  println("Hello, World!")

  val p = new Party()
  p.register(9)
  val cost = p.cost()
  println(s"costs for 10 people: $cost")
  p.cost()

  val e = new Employee()
  println(e.name)
}