name := "unit8"
version := "0.1"
scalaVersion := "2.13.12"

scalacOptions += "-Xfatal-warnings"
scalacOptions += "-deprecation"

val CirceVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion,
)