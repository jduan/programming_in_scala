package chapter10

// factory object
object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(ch: Char, width: Int, height: Int): Element =
    new UniformElement(ch, width, height)

  def elem(line: String): Element = new LineElement(line)
}

abstract class Element {
  def contents: Array[String]

  def height:  Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length
  // If width is defined as val, it will always be 0 even for objects of
  // subclasses of Element because it's initialized right here.
  // val width: Int = if (height == 0) 0 else contents(0).length

  def widen(w: Int): Element = {
    if (w <= width)
      this
    else {
      val left = Element.elem(' ', (w - width) / 2, height)
      val right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height)
      this
    else {
      val top = Element.elem(' ', width, (h - height) / 2)
      val bottom = Element.elem(' ', width, h - top.height - height)
      top above this above bottom
    }
  }

  def above(that: Element): Element =
    Element.elem(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    val cont = this.contents.zip(that.contents).map(t => t._1 + t._2)
    Element.elem(cont)

    // alternatively
    // for (
    //   (line1, line2) <- this.contents zip that.contents
    // ) yield line1 + line2
  }

  override def toString = contents mkString "\n"
}

abstract class Element2(conts: Array[String]) {
  val contents: Array[String] = conts
  val height: Int = conts.length
  val width: Int = if (height == 0) 0 else conts(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
  override def contents = conts
}

// this is how to pass arguments to parent class's constructor
class ArrayElement2(conts: Array[String]) extends Element2(conts)

class ArrayElement1(conts: Array[String]) extends Element {
  // override a parameterless method with a field because fields and methods in
  // Scala are in the same namespace!
  // Scala has only 2 namespaces:
  // values: fields, methods, packages, and singleton objects)
  // types: classes, and traits
  val contents: Array[String] = conts
}

// another way of overriding "contents" as a val and take it in the constructor
class ArrayElement3(val contents: Array[String]) extends Element

//val ae = new ArrayElement(Array("hello", "world"))
//
//val ae2 = new ArrayElement2(Array("hello", "world"))
//assert(ae2.width == 5)
//ae2.contents(0) = "San Francisco"
//assert(ae2.width == 5) // still 5, not 13 because width is a value, not a function


// modifiers
class Cat {
  val dangerous = false
}
class Tiger(
  override val dangerous: Boolean,
  private var age: Int
) extends Cat


class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}


// Note that the "override" modifier is required except for abstract methods.
// This is important when it comes to system evolution. One problem is when you
// add new members (fields or methods) to base classes, you risk breaking
// subclasses because they may have defined those members already. In Scala, you
// will see a compilation error which is really helpful.

class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}
