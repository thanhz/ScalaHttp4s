name := "ScalaHttp4s"

version := "0.1"

scalaVersion := "2.13.5"

val http4sVersion = "0.21.18"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion
)
