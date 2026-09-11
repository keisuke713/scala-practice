import my.example.io._
import my.areas.{Circle => C}

object Main extends App {
  println("Hello, World!")
  val e = new MyExample()
  println(e.readFileIntoString("./src/main/resource/hoge.txt"))
  val c = new C()
  println(c)
}