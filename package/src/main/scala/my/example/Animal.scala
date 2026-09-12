package my.example

trait Animal {
    def sleep = "ZzZ"

    def eat(food: String): String

    def move(x: Int, y: Int): String
}

class Cat extends Animal {
    override def eat(food: String) = "mao"
    override def move(x: Int, y: Int) = s"the cat is moving to ($x, $y)"
}

trait Namable {
    def name(): String
}

class Dog(val name: String) extends Animal with Namable {
    override def eat(food: String) = s"$food $food"
    override def move(x: Int, y: Int) = s"lets go to ($x, $y)"
}