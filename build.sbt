
lazy val commonSettings = Seq(
  organization := "de.surfice",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  libraryDependencies ++= Seq(
  ),
  scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = baseDirectory.value.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/jokade/angulate2-primeng"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      }))
)


lazy val primeng = project.in(file("."))
  .enablePlugins(Angulate2Plugin)
  .settings(commonSettings: _*)
  .settings( 
    name := "angulate2-primeng",
    libraryDependencies ++= Seq(
    )
  )

lazy val demo = project
  .enablePlugins(Angulate2Plugin)
  .dependsOn(primeng)
  .settings(commonSettings: _*)
  .settings(
    publish := {},
    publishLocal := {},
    ngBootstrap := Some("demo.AppModule")
  )

lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/angulate2-primeng</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/angulate2-primeng</url>
      <connection>scm:git:git@github.com:jokade/angulate2-primeng.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
