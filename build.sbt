import play.Project._

name := "activate-example-play"

version := "1.0"

resolvers ++= Seq(
  "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository",
  "Typesafe" at "http://repo.typesafe.com/typesafe/releases",
  "fwbrasil.net" at "http://fwbrasil.net/maven/"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  "net.fwbrasil" %% "activate-play" % "1.5" exclude("org.scala-stm", "scala-stm_2.10.0"),
  "net.fwbrasil" %% "activate-jdbc" % "1.5",
  "mysql" % "mysql-connector-java" % "5.1.16"
)

playScalaSettings

Keys.fork in Test := false