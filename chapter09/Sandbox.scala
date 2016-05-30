object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContainging(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}

val filenames = Array("a.scala", "b.java", "c.ruby", "d.scala")

filesEnding(filenames, "scala")


// currying
def curriedSum(x: Int)(y: Int) = x + y
assert(curriedSum(1)(2) == 3)

val onePlus = curriedSum(1)_

assert(onePlus(3) == 4)


def twice(op: Double => Double, x: Double) = op(op(x))


// In any method invocation in Scala in which you're passing in exactly one
// argument, you can opt to use curly braces to surround the argument instead of
// parentheses.

println { "hello, world" }
assert(curriedSum(1) { 2 } == 3)

def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

withPrintWriter(new File("date.txt")) { writer =>
  writer.println(new java.util.Date)
}


// by-name parameters

val assertionsEnabled = false
def myAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

// this line won't throw a java.lang.ArithmeticException (/ by zero) because the
// predicate passed in won't be executed until later.
myAssert(1 / 0 > 2)

// in contrast, if myAssert is defined as the following, there will be a problem
def myAssert(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

// here the parameter will be eagerly evaluated before being passed in the
// myAssert because the parameter isn't a function!
myAssert(1 / 0 > 2)
