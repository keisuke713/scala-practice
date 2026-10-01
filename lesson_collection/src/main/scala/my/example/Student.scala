package my.example

import java.time.LocalDate
import scala.util.{Failure, Success, Try}

case class Student(id: Int, name: String, topics: Set[String])
case class ExamSession(title: String, localDate: LocalDate, topic: String)

case class Registration(studentId: Int, examSession: ExamSession, localDate: LocalDate = LocalDate.now())

case object Registration {
    def register(student: Student, examSession: ExamSession): Try[Registration] = {
        if (student.topics.contains(examSession.topic))
            Success(Registration(student.id, examSession))
        else
            Failure(new IllegalStateException(
                s"Student ${student.id} is missing topic ${examSession.topic}"
            ))
    }
}

case class Pass(score: Int) {
    require(score >= 60 && score <= 100, "Invalid pass: score must be between 60 and 100")

    def toPercentage: Double = score / 100.0
}

case object Pass {
    def mark(score: Int, msg: Option[String] = None): Either[String, Pass] =
        if (score >= 60) Right(Pass(score))
        else Left(msg.getOrElse("Score below 60"))

    def toMessage(outcome: Either[String, Pass]): String =
        outcome match {
            case Left(msg) => s"Fail: $msg"
            case Right(pass) => s"Pass with score ${pass.score}"
        }

    def toPercentage(outcome: Either[String, Pass]): Either[String, Double] =
        outcome.map(_.toPercentage)

    def combine(outcomeA: Either[String, Pass], outcomeB: Either[String, Pass]): Either[String, Pass] = {
        outcomeA.flatMap { passA =>
            outcomeB.map { passB =>
                val averageScore = (passA.score + passB.score) / 2
                Pass(averageScore)
            }
        }
    }

    def getPreviewMessage(outcome: Either[String, Pass]): String =
        outcome.left.getOrElse("You passed the exam well done")

    def toPrettyMsg(registration: Try[Registration]): String =
        registration match {
            case Success(reg) => s"Student registered for exam session ${reg.examSession.title}"
            case Failure(ex) => s"Registration failed ${ex.getMessage}"
        }
}