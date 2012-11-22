import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "computer-database"
    val appVersion      = "1.0"

    val appDependencies = Nil
    
    val customResolvers = Seq(
  	    "fwbrasil.net" at "http://fwbrasil.net/maven/",
        "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  	)
  	
  	val activateCore = "net.fwbrasil" %% "activate-core" % "1.1"
  	val activatePlay = "net.fwbrasil" %% "activate-play" % "1.1"
  	val activateJdbc = "net.fwbrasil" %% "activate-jdbc" % "1.1"
    val mysql = "mysql" % "mysql-connector-java" % "5.1.16"

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      libraryDependencies ++= Seq(activateCore, activatePlay, activateJdbc, mysql),
    	resolvers ++= customResolvers
    )

}
            
