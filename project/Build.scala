import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "computer-database"
    val appVersion      = "1.0"

    val appDependencies = Nil
    
    val customResolvers = Seq(
  	    "snapshots" at "http://scala-tools.org/repo-snapshots",
  	    "releases" at "http://scala-tools.org/repo-releases",
  	    "Maven" at "http://repo1.maven.org/maven2/",
//  	    "www.mvnsearch.org" at "http://www.mvnsearch.org/maven2/",
  	    "fwbrasil.net" at "http://fwbrasil.net/maven/",
  	    "reflections" at "http://reflections.googlecode.com/svn/repo",
  	    "vaadin-addons" at "http://maven.vaadin.com/vaadin-addons",
  	    "ibiblio" at "http://mirrors.ibiblio.org/pub/mirrors/maven2/",
  	    "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  	)
  	
  	val activateCore = "net.fwbrasil" %% "activate-core" % "1.0-SNAPSHOT"
  	val activatePlay = "net.fwbrasil" %% "activate-play" % "1.0-SNAPSHOT"

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here
//    		scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8"),
    	libraryDependencies ++= Seq(activateCore, activatePlay),
    	resolvers ++= customResolvers
    )

}
            
