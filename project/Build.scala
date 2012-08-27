import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "computer-database"
    val appVersion      = "1.0"

    val appDependencies = Nil
    
    val customResolvers = Seq(
  	    "fwbrasil.net" at "http://fwbrasil.net/maven/"
  	)
  	
  	val activateCore = "net.fwbrasil" %% "activate-core" % "1.0"
  	val activatePlay = "net.fwbrasil" %% "activate-play" % "1.0"

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here
//    		scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8"),
    	libraryDependencies ++= Seq(activateCore, activatePlay),
    	resolvers ++= customResolvers
    )

}
            
