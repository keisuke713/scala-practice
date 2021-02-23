package org.example.registrations

import io.getquill.{PostgresAsyncContext, SnakeCase}
import scala.concurrent.{ExecutionContext, Future}

class Queries(ctx: PostgresAsyncContext[SnakeCase.type]) {

  import ctx._
  
  def testConnection()(implicit ec: ExecutionContext): Future[Boolean] = {
    val q = quote { infix"SELECT 1".as[Int] }
    run(q).map(_ == 1)
  }
}