import my.example._
import java.time.LocalDate

object Main extends App {
    println("lesson collection")

    // val historySession = ExamSession(
    //     "History", localDate = LocalDate.now.plusDays(30)
    // )
    // val chemistrySession = ExamSession(
    //     "chemistory", localDate = LocalDate.now.plusDays(45)
    // )

    // val alice = Student(id = 1, name = "Alice")
    // val bob = Student(id = 2, name = "Bob")
    // val charlie = Student(id = 3, name = "Charlie")

    // val registration: Map[ExamSession, List[Student]] =
    //     Map(
    //         historySession -> List(alice, bob),
    //         chemistrySession -> List(alice, charlie)
    //     )

    // println(registration)
    // println(registration + (historySession -> List(bob)))

    // println(registration.map { case (examSession, students) =>
    //     (examSession, students.size)
    // })


    val capital = Map("tokyo" -> "japan", "rome" -> "italy", "london" -> "uk")
    val country = Map("japan" -> "asia", "italy" -> "europe")
    val continent = capital.map { case (capital, c) =>
        (capital, country.getOrElse(c, "unknown"))
    }
    println(continent)
    println(s"${capital.maxBy { case (capital, _) => capital.length }}")

    val p1 = Person.applyV2("30-keisuke")
    println(s"$p1")
    val p2 = Person.applyV2("nebashi-keisuke")
    println(s"$p2")
}