package my.example

case class Library() {
    def search(title: String, author: String, ISBN: String): Book = ???
}

case class Book(title: String, author: String, ISBN: String, totalPages: Int) {
}

object Book {
    def unapply(b: Book): Option[(String, String, String)] = {
        if (b.totalPages < 10) None
        else Some((b.title, b.author, b.ISBN))
    }
}