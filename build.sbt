name := "doma-joda-time"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.1",
  "org.seasar.doma" % "doma" % "[1.24.0,)",
  "com.h2database" % "h2" % "1.3.170" % "test",
  "junit" % "junit" % "4.8.1" % "test"
)

resolvers ++= Seq(
  "seasar" at "http://maven.seasar.org/maven2/"
)

organization := "jp.t2v"

publishTo := sys.env.get("LOCAL_MAVEN_REPO").map { dir =>
  Resolver.file("maven-repo", file(dir))(Patterns(true, Resolver.mavenStyleBasePattern))
}

