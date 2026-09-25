package my.example

case class Contact(name: String, surname: String, numbers: List[ContactNumber], company: Option[String], email: Option[String])

sealed trait Label2
case object Work extends Label2
case object Home extends Label2

case class ContactNumber(number: String, label: Label2)

