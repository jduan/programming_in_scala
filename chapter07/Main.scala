class MyBreakableException extends Exception

def mybreak = throw new MyBreakableException

def myBreakable(block: => Unit) = {
  try {
    block
  } catch {
    case ex: MyBreakableException =>
      // expected
    case ex: Throwable => throw ex
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println("entering main")
    // def searchFrom(i: Int): Int = {
    //   if (i >= args.length) -1
    //   else if (args(i).startsWith("-")) searchFrom(i + 1)
    //   else if (args(i).endsWith(".scala")) i
    //   else searchFrom(i + 1)
    // }
    // println(s"Found ${searchFrom(0)}");

    myBreakable {
      var i = 0;
      while (true) {
        println(s"i is $i")
        i += 1
        if (i == 10) mybreak
      }
    }
  }
}
