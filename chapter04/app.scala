// A singleton object that does not share the same name with a companion class
// is called a standalone object. You can use standalone objects for many
// purposes, including collecting related utility methods together or defining
// an entry point to a Scala application.

import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(s"$arg: ${calculate(arg)}")
  }
}

// or

object Summer2 extends App {
  for (arg <- args)
    println(s"$arg: ${calculate(arg)}")
}
