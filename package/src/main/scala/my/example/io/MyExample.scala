package my.example.io

import scala.io.Source

class MyExample {
    def readFileIntoString(filepath: String) =
        Source.fromFile(filepath).getLines().mkString("\n")
}