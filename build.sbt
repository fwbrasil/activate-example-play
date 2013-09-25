import play.Project._

name := "activate-example-play"

version := "1.0"

resolvers ++= Seq(
  "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository",
  "fwbrasil.net" at "http://fwbrasil.net/maven/"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  "net.fwbrasil" %% "activate-core" % "1.3",
  "net.fwbrasil" %% "activate-play" % "1.3" exclude("org.scala-stm", "scala-stm_2.10.0"),
  "net.fwbrasil" %% "activate-jdbc" % "1.3",
  "mysql" % "mysql-connector-java" % "5.1.16"
)

playScalaSettings

Keys.fork in Test := false