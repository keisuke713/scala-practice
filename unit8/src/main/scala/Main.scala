import java.time.{LocalDate, Period}
import io.circe._

case class Person(fullName: String, dateOrBirth: LocalDate)

object Person {
    implicit val personEncoder: Encoder[Person] = new Encoder[Person] {
        override def apply(person: Person): Json = {
            val age = Period.between(person.dateOrBirth, LocalDate.now()).getYears
            Json.obj("fullName" -> Json.fromString(person.fullName), "age" -> Json.fromInt(age))
        }
    }

    implicit val personDecoder: Decoder[Person] = new Decoder[Person] {
        override def apply(c: HCursor): Either[DecodingFailure, Person] = {
            for {
                fullName <- c.downField("fullName").as[String]
                dateOfBirth <- c.downField("dateOfBirth").as[LocalDate]
            } yield Person(fullName, dateOfBirth)
        }
    }
}




implicit val dateEncoder: Encoder[LocalDate] = new Encoder[LocalDate] {
    override def apply(date: LocalDate): Json = {
        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        Json.fromString(date.format(formatter))
    }
}

implicit val dateDecoder: Decoder[LocalDate] = new Decoder[LocalDate] {
    override def apply(c: HCursor): Either[DecodingFailure, LocalDate] = {
        for {
            dateString <- c.as[String]
            d <- LocalDate.parse(dateString)
        } yield d
    }
}