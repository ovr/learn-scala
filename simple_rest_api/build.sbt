name := "simple_rest_api"

version := "1.0"

lazy val `simple_rest_api` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

//http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.postgresql%22%20AND%20a%3A%22postgresql%22
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc41"

libraryDependencies += "com.typesafe.play" %% "anorm" % "2.4.0"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  