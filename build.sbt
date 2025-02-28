name := "Main"
version := "0.1"
scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.13" % "3.9.0",
  "org.apache.kafka" % "kafka-clients" % "3.9.0",
  "org.slf4j" % "slf4j-log4j12" % "2.0.16"
)


enablePlugins(AssemblyPlugin)

assembly / assemblyMergeStrategy := {
  case x if x.contains("META-INF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}

logLevel := Level.Info
