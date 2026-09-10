abstract class Person(val name: String, val age: Int) {
  def present() = s"i am $name, $age years old"
  def hello(): String
}

class Studnet(name: String, age: Int, val trackID: String) extends Person(name, age) {
  override def present() = s"oh yeah. i am $name, $age years old, trackID is $trackID"
  override def hello() = "kei"
}