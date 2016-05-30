package chapter10

object Main extends App {
  val le = Element.elem("hello")
  println(le)

  println(le widen 10 heighten 5)
}