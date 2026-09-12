package my.example

abstract class Robot(name: String) {
    def welcome: String
}

object Robot {
    def mostTalkative(r1: Robot, r2: Robot): Robot = {
        val r1Size = r1.welcome.length
        val r2Size = r2.welcome.length

        if (r1Size > r2Size) r1 else r2
    }
}

object Vocabulary {
    val sentenceA = "Hi there"
    val sentenceB = "welcome"
    val sentenceC = "hello"
}
