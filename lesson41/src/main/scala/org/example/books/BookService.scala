package org.example.books

import org.example.books.entities._
import org.slf4j.{Logger, LoggerFactory}

class BookService(bookCatalogPath: String) {

  private val logger: Logger = LoggerFactory.getLogger(this.getClass)

  private val books: List[Book] =
    new BookParser(bookCatalogPath).books

  private var bookLoans: Set[BookLoan] = Set.empty

  def search(title: Option[String] = None,
             author: Option[String] = None): List[Book] =
    books.filter { book =>
      title.forall { t => containsCaseinsensitive(book.title, t) } &&
      author.forall { a => book.authors.exists { containsCaseinsensitive(_, a) } }
    }

  def reserveBook(bookId: Long, user: User): Either[String, BookLoan] = {
    val res = for {
      _ <- checkReserveLimit(user)
      book <- checkBookExists(bookId)
      _ <- checkBookIsAvailable(book)
    } yield registerBookLoan(book, user)
    logger.info(s"Book $bookId - User ${user.id} - " + s"Reserve request: ${outcomeMsg(res)}")

    res
  }

  def returnBook(bookId: Long): Either[String, BookLoan] = {
    val res = for {
      book <- checkBookExists(bookId)
      user <- checkBookIsTaken(book)
    } yield unregisterBookLoan(book, user)
    logger.info(s"Book $bookId - Return request: ${outcomeMsg(res)}")
    res
  }

  private def containsCaseinsensitive(str: String, subStr: String): Boolean =
    str.toLowerCase.contains(subStr.toLowerCase)

  private def outcomeMsg[T](res: Either[String, T]): String =
    res.left.getOrElse("OK")

  private val loanLimit = 5
  private def checkReserveLimit(user: User): Either[String, User] = {
    if (bookLoans.count(_.user == user) < loanLimit) {
      Right(user)
    } else {
      Left(s"User ${user.id} has reached the maximum number of loans ($loanLimit)")
    }
  }

  private def checkBookExists(bookId: Long): Either[String, Book] =
    books.find(_.id == bookId) match {
      case Some(book) => Right(book)
      case None => Left(s"Book with id $bookId does not exist")
    }

  private def checkBookIsAvailable(book: Book): Either[String, Book] =
    findBookLoan(book) match {
      case Some(_) => Left(s"Book ${book.id} is already loaned out")
      case None => Right(book)
    }

  private def findBookLoan(book: Book): Option[BookLoan] =
    bookLoans.find(_.book == book)

  private def registerBookLoan(book: Book, user: User): BookLoan = {
    val bookLoan = BookLoan(book, user)
    updateBookLoans(loans => loans + bookLoan)
    bookLoan
  }

  private def updateBookLoans(f: Set[BookLoan] => Set[BookLoan]): Unit = {
    synchronized { 
      bookLoans = f(bookLoans)
    }
  }

  private def checkBookIsTaken(book: Book): Either[String, User] =
    findBookLoan(book) match {
      case Some(bookLoan) => Right(bookLoan.user)
      case None => Left(s"Book ${book.id} does not result out on loan")
    }

  private def unregisterBookLoan(book: Book, user: User): BookLoan = {
    val bookLoan = BookLoan(book, user)
    updateBookLoans(loans => loans - bookLoan)
    bookLoan
  }
}
