import my.example.io._
import my.areas.{Circle => C}
import my.example._

// object Main extends App {
//   val assistant = Assistant(1, "assistant2")
//   val tutor = Professor(1, "agasa", Some(assistant))
//   val s = Student(1, "kei", Some(tutor))
//   // val s = Student(1, "kei", None)
//   println(s"${s.tutorName().getOrElse("unknown")}")
//   println(s"${s.assistantName()}")
//   println(s"${s.hasTutorWith(1).map(_.name).getOrElse("unknown")}")


//   // val kei = Driver("kei", 30, Some("license"))
//   // val yume = Driver("yume", 24, None)
//   // val car1 = Car("tesla", Some(kei), None)
//   // val car2 = Car("tesls", Some(yume), None)
//   // val car3 = Car("tesls", None, None)
//   // println(car1.ownerBelowAge(30).getOrElse("unknown"))
//   // println(car1.ownerDrivingLicense("kei").find(_.length < 10))
//   // println(car1.licensedOwner())
//   // println(car2.licensedOwner())
//   // println(car3.licensedOwner())
//   // println(car1.ownerDrivingLicenseV2())
//   // def f(n: Int): Option[Int] =
//   //   if (n < 5) Some(n * 2)
//   //   else None

//   // def foo(optA: Option[Int]) =
//   //   for {
//   //     a <- optA
//   //     b <- f(a)
//   //     c <- Some(5 * b)
//   //   } yield c

//   // println(foo(Some(1)))
//   // println(foo(Some(5)))
//   // println(foo(None))
// }

object Main {
  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    print(s"res: ${filter(nums, Nil)}")
  }
  def filter(nums: List[Int], res: List[Int]): List[Int] =
    nums match {
      case Nil => res
      case head :: tail =>
        if (head % 2 == 0) filter(tail, res :+ head)
        else filter(tail, res)
    }
}

// object JPN extends Currency {
//   def unit = "yen"
// }