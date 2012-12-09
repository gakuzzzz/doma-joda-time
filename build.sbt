name := "doma-joda-time"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.1",
  "org.seasar.doma" % "doma" % "[1.26.0,)",
  "com.h2database" % "h2" % "1.3.170" % "test",
  "junit" % "junit" % "4.8.1" % "test",
  "com.novocode" % "junit-interface" % "0.10-M2" % "test"
)

resolvers ++= Seq(
  "seasar" at "http://maven.seasar.org/maven2/"
)

organization := "jp.t2v"

publishTo := sys.env.get("LOCAL_MAVEN_REPO").map { dir =>
  Resolver.file("maven-repo", file(dir))(Patterns(true, Resolver.mavenStyleBasePattern))
}

javacOptions in Test ++= Seq(
  "-Adomain.converters=jp.t2v.lab.doma.jodatime.DomainConverterProvider", 
  "-Asql.validation=false"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
