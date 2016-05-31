package chapter12

/**
  * Created by jduan on 5/30/16.
  */
class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

abstract class Component extends Rectangular

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {

}

class Rational(val numer: Int, val denom: Int)  extends Ordered[Rational] {
  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}

object Main extends App {
  val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
  assert(rect.left == 1)
  assert(rect.right == 10)
  assert(rect.width == 9)

  val half = new Rational(1, 2)
  val third = new Rational(1, 3)
  assert(third < half)
  assert(half > third)
}