name := "activate-example-play"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.4"

val activateVersion = "1.6.3"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.scalatestplus" %% "play" % "1.1.0" % "test",
  "net.fwbrasil" %% "activate-play" % activateVersion,
  "net.fwbrasil" %% "activate-jdbc" % activateVersion,
  "net.fwbrasil" %% "activate-slick" % activateVersion,
  "net.fwbrasil" %% "activate-core" % activateVersion
)

Keys.fork in Test := false
