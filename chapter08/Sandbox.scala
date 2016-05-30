// var-args
def echo(args: String*) = {
  for (arg <- args)
    println(arg)
}

echo("hello", "world")

val arr = Array("What's", "up", "doc?")
// echo (arr)
echo(arr: _*)


// named arguments
def speed(distance: Float, time: Float): Float = distance / time

speed(100, 3)
speed(time = 3, distance = 100)


// default arguments
def printTime(out: java.io.PrintStream = scala.Console.out,
  divisor: Int = 1) = {
  out.println("time = " + System.currentTimeMillis() / divisor)
}

printTime()
printTime(scala.Console.err)
printTime(out = scala.Console.err)
printTime(divisor = 1000)


// tracing regular functions
def boom(x: Int): Int = {
  if (x == 0)
    throw new Exception("boom!")
  else
    boom(x - 1) + 1
}

// tracing tail-recursive functions
// there's only one stack frame for "bang"
def bang(x: Int): Int = {
  if (x == 0)
    throw new Exception("bang!")
  else
    bang(x - 1)
}
