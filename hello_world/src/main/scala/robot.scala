class Robot(val name: String = "unknown") {
    def welcome(n: String) = s"hi welcome $n, i an $name"
}

class ItalianRobot(name: String) extends Robot(name) {
  override def welcome(n: String) =
    s"Benveuto $n! Il mio nome e $name"
}

class EnglishRobot(name: String, val country: String) extends Robot(name) {
  override def welcome(n: String) =
    s"Welcome $n, I am $name from the $country oh yeah!"
}