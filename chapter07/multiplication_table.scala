import scala.collection.Seq

def buildMultiplicationTable(n: Int): Seq[String] = {
  val width = (n * n).toString.length + 1

  def makeRow(row: Int): String = {
    val cells = for (i <- 1 to n) yield {
      val value = (row * i).toString
      val padding = " " * (width - value.length)
      padding + value
    }

    cells.mkString("")
  }

  def makeRows(n: Int): Seq[String] = {
    for (i <- 1 to n) yield makeRow(i)
  }

  makeRows(n)
}

def printMultiplicationTable(n: Int): Unit = {
  println(buildMultiplicationTable(n).mkString("\n"))
}

object Main extends App {
  printMultiplicationTable(20)
}

Main.main(args)
