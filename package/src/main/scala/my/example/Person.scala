package my.example

class Person(val name: String, val age: Int) {
  def present() = s"i am $name, $age years old"
  def hello() = "hi"
}

object Person {
  def apply(name: String, age: Int) = new Person(name, age)

  def apply(p1: Person, p2: Person): Person = {
    new Person(
      s"Son of ${p1.name} and ${p2.name}", 0
    )
  }

  def apply(p: Person): Person = 
    new Person(p.name, p.age)

  def isOlder(p1: Person, p2: Person) = 
    if (p1.age > p2.age) p1 else p2
}