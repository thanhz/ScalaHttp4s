import cats.effect._

object Runner extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    HttpServer.create()
  }
}
