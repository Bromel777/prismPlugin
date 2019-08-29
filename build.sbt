lazy val ideaSettings = Def.settings(
  name := "prismPlugin",
  version := "0.1",
  scalaVersion := "2.13.0",
  ThisBuild / ideaPluginName := "prismIdeaPlugin",
  ThisBuild / ideaEdition := IdeaEdition.Community,
  ThisBuild / ideaBuild := "191.6183.87",
  ideaInternalPlugins := Seq(),
)

lazy val prismPlugin: sbt.Project =
  project.in(file("."))
    .settings(ideaSettings)
    .enablePlugins(SbtIdeaPlugin)

val ideaRunner = createRunnerProject(prismPlugin, "idea-runner")