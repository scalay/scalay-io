import sbt._
import sbt.{FileUtilities => Files}

class ScalayProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
}
