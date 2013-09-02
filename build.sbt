name := "doma-joda-time"

version := "1.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "joda-time"       % "joda-time"       % "2.3",
  "org.seasar.doma" % "doma"            % "1.33.0",
  "com.h2database"  % "h2"              % "1.3.170" % "test",
  "junit"           % "junit"           % "4.8.1"   % "test",
  "com.novocode"    % "junit-interface" % "0.10-M2" % "test"
)

resolvers ++= Seq(
  "seasar" at "http://maven.seasar.org/maven2/",
  "seasar snapshots" at "http://maven.seasar.org/maven2-snapshot/"
)

organization := "jp.t2v"

publishTo := sys.env.get("LOCAL_MAVEN_REPO").map { dir =>
  Resolver.file("maven-repo", file(dir))(Patterns(true, Resolver.mavenStyleBasePattern))
}

javacOptions in Compile ++= Seq(
  "-Aversion.validation=false"
)

javacOptions in Test ++= Seq(
  "-Adomain.converters=jp.t2v.lab.doma.jodatime.DomainConverterProvider", 
  "-Asql.validation=false"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}

crossPaths := false
