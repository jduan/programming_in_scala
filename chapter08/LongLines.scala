import scala.io.Source

def processLongLines(filename: String, width: Int): Unit = {
  def processLine(line: String) {
    if (line.length > width)
      println(s"$filename: $line")
  }
  val source = Source.fromFile(filename)
  for (line <- source.getLines())
    processLine(line)
}

object Main extends App {
  val width = args(0).toInt
  for (filename <- args.drop(1))
    processLongLines(filename, width)
}

Main.main(args)
