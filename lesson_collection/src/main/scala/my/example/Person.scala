package my.example

import scala.util.{Success, Failure, Try}

case class Person(age: Int, name: String)

case object Person {
    def applyV2(text: String): Try[Person] = {
        val ageAndName = text.split("-")
        if (ageAndName.length != 2) return Failure(new IllegalArgumentException("you have to provide name and age"))

        val tryAge = Try(ageAndName(0).toInt)
        if (tryAge.isFailure) return Failure(new IllegalArgumentException("age must be int"))
        Try(Person(tryAge.getOrElse(0), ageAndName(1)))
    }

    def parse(text: String): Try[Person] = Try {
        val List(age, name) = text.split("-").toList
        Person(age.toInt, name)
    }
}