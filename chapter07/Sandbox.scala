// Look for opportunities to use vals. They can make your code both easier to
// read and easier to refactor.
val filename = if (args.isEmpty) "default.txt" else args(0)

def gcd(x: Long, y: Long): Long = {
  var a = x
  var b = y
  // while loops return Unit. It's called the unit value and is written ().
  // Because the while loop results in no value, it's often left out of pure
  // functional languages. Such languages have expressions, not loops.
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }

  b
}

// functional style
def gcd(x: Long, y: Long): Long =
  if (y == 0) x else gcd(y, x % y)

// In general, we recommend you challenge while loops in your code in the same
// way you challenge vars. In fact, while loops and vars often go hand in hand.

// For expressions
// Scala's for expression is a Swiss army knife of iteration.
val files = (new java.io.File(".")).listFiles
for (file <- files)
  println(file)

// ranges
for (i <- 1 to 4) // or until
  println(s"Iterations $i")

val files = (new java.io.File(".")).listFiles
for (file <- files if file.getName.endsWith(".scala"))
  println(file)

for (
  file <- files
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)

// nested for loops
for (
  file <- files
  if file.getName.endsWith(".scala");
  line <- fileLines(file)
  if line.trim.matches(pattern)
) println(file + ":" + line.trim)

for (file <- files;
     line <- fileLines(file)) {
  println(file)
}

// mid-stream variable bindings
for (
  file <- files
  if file.getName.endsWith(".scala");
  line <- fileLines(file)
  trimmed = line.trim
  if trimmed.matches(pattern)
) println(file + ":" + trimmed)

// yield
for (i <- 1 to 10) yield i // returns a scala.collection.immutable.IndexedSeq[Int]
for (i <- 1 to 10) yield {
  // do more complicated things
}

// throw and catch exceptions
try {
  val f = new FileReader("input.txt")
  // use and close file
} catch {
  // pattern matching
  case ex: FileNotFoundException => // handle missing file
  case ex: IOException => // handle other I/O error
} finally {
  // ...
}

// scala doesn't require you to catch checked exceptions or declare them in a
// throws clause.

// return value
// The last expression in the try block or the catch block is the return value.
// However, if the finally block includes an explicit return statement, or
// throws an exception, that return value or exception will "overrule" any
// previous one that originated in the try block or one of its catch clauses.

def f(): Int = try return 1 finally return 2
// calling f() results in 2

def g(): Int = try 1 finally 2
// calling f() results in 1

// So it's usually best to avoid returning values from finally clauses. The best
// way to think of finally clauses is as a way to ensure some side effect
// happens, such as closing an open file.



// match expressions
val firstArg = if (args.length > 0) args(0) else ""
val friend = firstArg match {
  case "salt" => "pepper"
  case "chips" => "salsa"
  case "eggs" => "bacon"
  case _ => "huh?"
}
println(friend)

def searchFrom(i: Int): Int = {
  if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i
  else searchFrom(i + 1)
}

import scala.util.control.Breaks._
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "") break
  }
}

// my breakable
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
