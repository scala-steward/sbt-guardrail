
name := "sbt-guardrail-scala-client-test-app"

version := "1.0." + System.currentTimeMillis

scalaVersion := "2.12.18"

scalacOptions += "-Xexperimental"

Compile / guardrailTasks := GuardrailHelpers.createGuardrailTasks((Compile / sourceDirectory).value / "openapi") { openApiFile =>
  List(
    ScalaClient(openApiFile.file),
  )
}

Compile / scalafmt / unmanagedSources ++= (Compile / guardrail).value