import cats.effect.{ContextShift, ExitCode, IO, Timer}
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT
import org.http4s.server.blaze.BlazeServerBuilder
import service.HelloService

import scala.concurrent.ExecutionContext.Implicits.global

object HttpServer {
  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)

  def create() = {
    for {
      exitCode <- BlazeServerBuilder[IO](global)
        .bindHttp(8080, "localhost")
        .withHttpApp(new HelloService().routes.orNotFound)
        .serve
        .compile
        .drain.as(ExitCode.Success)
    } yield exitCode
  }

}
