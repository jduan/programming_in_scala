package chapter11

/**
  * Created by jduan on 5/30/16.
  */

class Dollars(val amount: Int) extends AnyVal {
  override def toString = "$" + amount
}

// value classes!
// These classes/types help the compiler catch errors. They are better than plain strings.
class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal

object Sandbox extends App {
  def divide(x: Int, y: Int): Int =
    if (y != 0) x / y
    else
      throw new Exception("can't divide by zero!")

  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" +
      text.value +
      "</h1></a>"
    )

  println(divide(10, 2))
  // println(divide(10, 0))

  val tenDollars = new Dollars(10)
  println(tenDollars)
  println(tenDollars.amount)

  println(title(new Text("hello world"), new Anchor("hi"), new Style("anchor")).value)
  // the following line would cause a compilation error because of type mismatch
  // println(title(new Text("hello world"), new Style("hi"), new Style("anchor")).value)
}