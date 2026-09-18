case class Student(id: Long, name: String, tutor: Option[Professor]) {
    def tutorName(): Option[String] = {
        tutor.map(_.name)
    }

    def assistantName(): Option[String] = {
        // tutor.flatMap(_.assistant).map(_.name)
        tutor.flatMap(_.assistant.map(_.name))
    }

    def hasTutorWith(id: Long): Option[Student] = {
        tutor.flatMap { t =>
            if (t.id == id) Some(this)
            else None
        }
    }
}
case class Professor(id: Long, name: String, assistant: Option[Assistant])
case class Assistant(id: Long, name: String)
