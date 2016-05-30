// Intuitively, Scala's closures capture variables themselves, not the value to
// which variables refer.
// The captured variables live out on the heap instead of the stack, and thus
// can outlive the method call that created it.
def closure() = {
  val x = 10
  def addX(a: Int) = {
    a + x
  }

  // normal case
  assert(addX(10) == 20)

  var y = 20
  def addY(a: Int) = {
    a + y
  }

  assert(addY(10) == 30)

  // when y is changed, addY sees the change
  y = 200
  assert(addY(10) == 210)


  val nums = List(1,2,3,4)
  var sum = 0
  nums.foreach(sum += _)

  // closure nums.foreach is allowed to change 'sum', in other words,
  // changes made by a closure to a captured variable are visible outside the
  // closure.
  assert(sum == 10)
}

object Main extends App {
  closure
}

Main.main(args)
