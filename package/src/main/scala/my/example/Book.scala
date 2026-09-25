package my.example



case class Book(title: String, author: List[String], genre: Genre) {
}

sealed trait Genre
case object Action extends Genre
case object Comic extends Genre
case object Drama extends Genre
