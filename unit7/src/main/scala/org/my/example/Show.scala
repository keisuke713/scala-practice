package my.example

trait Show[T] {
    def show(value: T): String
}

object Show {
    implicit val stringShow: Show[String] = new Show[String] {
        def show(value: String): String = value + " nebashi"
    }

    implicit val intShow: Show[Int] = new Show[Int] {
        def show(value: Int): String = value.toString
    }

    // implicit val listShow: Show[List[T]] = new Show[List[T]] {
    //     def show(value: List[T]): String = value.map(implicitly[Show[T]].show).mkString("[", ", ", "]")
    // }

    implicit val personShow: Show[Person] = new Show[Person] {
        def show(value: Person): String = s"${value.name} is ${value.age} years old."
    }
}

case class Person(name: String, age: Int)