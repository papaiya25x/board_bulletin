name := """zerotoone_board"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.8"

libraryDependencies += guice

// https://mvnrepository.com/artifact/org.projectlombok/lombok
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.8" % "provided"

// https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.9"

// https://mvnrepository.com/artifact/io.ebean/ebean
libraryDependencies += "io.ebean" % "ebean" % "11.22.10"

libraryDependencies += "com.h2database" % "h2" % "1.4.192"

includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)
EclipseKeys.preTasks := Seq(compile in Compile)