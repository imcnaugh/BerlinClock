
lazy val berlinClockDeps = Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test"
)

libraryDependencies ++= berlinClockDeps

assemblyJarName in assembly := "berlinClock.jar"