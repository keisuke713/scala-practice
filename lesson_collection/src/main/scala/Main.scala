import my.example._
import java.time.LocalDate

object Main extends App {
    println("lesson collection")

    val historySession = ExamSession(
        "History", localDate = LocalDate.now.plusDays(30)
    )
    val chemistrySession = ExamSession(
        "chemistory", localDate = LocalDate.now.plusDays(45)
    )

    val alice = Student(id = 1, name = "Alice")
    val bob = Student(id = 2, name = "Bob")
    val charlie = Student(id = 3, name = "Charlie")

    val registration: Map[ExamSession, List[Student]] =
        Map(
            historySession -> List(alice, bob),
            chemistrySession -> List(alice, charlie)
        )

    println(registration)
    println(registration + (historySession -> List(bob)))

    println(registration.map { case (examSession, students) =>
        (examSession, students.size)
    })


    val capital = Map("tokyo" -> "japan", "rome" -> "italy", "london" -> "uk")
    val country = Map("japan" -> "asia", "italy" -> "europe")
    val continent = capital.flatMap { case (capital, country1) =>
        country.flatMap { case (country2, continent) =>
            if (country1 == country2) Some(capital -> continent) else None
        }
    }
    // val continent =
    //     for {
    //         (capital, country1) <- capital
    //         (country2, continent) <- country
    //         if country1 == country2
    //     } yield Some(capital, continent)
    println(continent)
}