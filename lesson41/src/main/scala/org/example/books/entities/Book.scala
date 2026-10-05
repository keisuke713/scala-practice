package org.example.books.entities

import scala.util.{Failure, Success, Try}
import java.net.URL

case class Book(id: Long,
                title: String,
                authors: List[String],
                imageUrl: Option[URL]) {

  def toPrettyString: String =
    s"[$id] $title ${authors.mkString("{", ", ", "}")}"
}

object Book {

  def parse(row: Map[String, String]): Try[Book] =
    for {
      id <- parseLong(row, "id")
      title <- parseString(row, "title")
      authors <- parseStrings(row, "authors")
    } yield {
      val imageUrl = parseURL(row, "image_url").toOption
      Book(id, title, authors, imageUrl)
    }

  private def parseAs[T](row: Map[String, String], key: String, parser: String => T): Try[T] = 
    for {
      value <- getValue(row, key)
      t <- Try(parser(value))
    } yield t

  private def getValue(row: Map[String, String], key: String): Try[String] =
    row.get(key) match {
      case Some(value) => Success(value)
      case None => Failure(new IllegalArgumentException(s"could not find column $key in row - row was $row"))
    }

  private def parseLong(row: Map[String, String], key: String): Try[Long] =
    parseAs(row, key, _.toLong)

  private def parseString(row: Map[String, String], key: String): Try[String] =
    parseAs(row, key, x => x)

  private def parseStrings(row: Map[String, String], key: String): Try[List[String]] =
    parseAs(row, key, x => x.split(",").map(_.trim).toList)

  private def parseURL(row: Map[String, String], key: String): Try[URL] =
    parseAs(row, key, x => new URL(x))
}

