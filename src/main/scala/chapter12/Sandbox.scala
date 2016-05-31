package chapter12

/**
  * Created by jduan on 5/30/16.
  */
trait Philosophical {
  override def toString = {
    " Philosophical " + super.toString
  }

  def philosophize() = {
    println("I consume memory, therefore I am!")
    // The line below is invalid because philosophize is not a member of AnyRef
    // super.philosophize()
  }
}

class Frog {
  // class Frog extends Philosophical {
  override def toString = "green " + super.toString
}

class Animal {
  override def toString = {
    " animal " + super.toString + " done"
  }

  def philosophize() = {
    println("philosophize from Animal")
  }
}

class Turtle extends Animal with Philosophical {
  override def toString = {
    " turtle " + super.toString
  }

  override def philosophize() = {
    println("philosophize from Turtle")
    super.philosophize()
  }
}

object Sandbox extends App {
  val frog = new Frog
  // frog.philosophize()
  println(frog)

  val turtle = new Turtle
  println(turtle.toString)

  turtle.philosophize()
}
