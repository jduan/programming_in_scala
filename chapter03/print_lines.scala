import scala.io.Source

def widthOfLength(s: String) = s.length.toString.length

def maxWidth(lines: List[String]) = {
  val maxLine = lines.maxBy(line => line.length)
  widthOfLength(maxLine)
}

if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList
  val width = maxWidth(lines)
  lines.foreach(line => {
    val numSpaces = width - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  })
} else {
  Console.err.println("Please enter filename")
}
