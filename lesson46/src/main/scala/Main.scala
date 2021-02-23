import org.example.registrations._
import java.nio.file.Paths

object Main extends App {

  // val psql = new PostgreSQL("init.sql")

  // println(s"PostgreSQL URL: ${psql.config.getString("url")}")

  // psql.stop()

  println(Paths.get("").toAbsolutePath)
}