import my.example.io._
import my.areas.{Circle => C}
import my.example._

object Main extends App {
  val assistant = Assistant(1, "assistant2")
  val tutor = Professor(2, "agasa", Some(assistant))
  val s = Student(1, "kei", Some(tutor))
  println(s"${s.assistantName()}")
  println(s"${s.hasTutorWith(1)}")
}

// object Main {
//   def main(args: Array[String]): Unit = {
//     println("hello from main object")

//     val c = new Cat()
//     c.eat("cheese")
//     c.move(1,2)

//     val d = new Dog("hana")
//     println(d.name)

//     println(USD.unit)
//   }
// }

// object JPN extends Currency {
//   def unit = "yen"
// }