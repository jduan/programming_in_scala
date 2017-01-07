package chapter15

import math.{E, Pi}

/**
  * Created by jduan on 5/30/16.
  */
object Sandbox extends App {
  val ret = E match {
    case Pi => "strange math? Pi = " + Pi
    case _ => "OK"
  }
  assert(ret == "OK")

  val pi = math.Pi
  val ret2 = E match {
    case pi => "strange math? pi = " + pi
    // case _ => "OK"  // if uncommented, you get a compiler warning here
  }
  assert(ret2 == s"strange math? pi = ${math.E}")

  val ret3 = E match {
    case `pi` => "strange math? pi = " + pi
    case _ => "OK"  // you get a compiler warning here
  }
  assert(ret3 == "OK")

  val expr = List(0, 1, 2)
  val ret4 = expr match {
    case List(0, _, _) => "found it"
    case _ => "didn't find it"
  }
  assert(ret4 == "found it")

  val ret5 = expr match {
    // match zero or more elements
    case List(0, _*) => "found it"
    case _ => "didn't find it"
  }
  assert(ret5 == "found it")

  val t = ("hello", 100, true)
  t match {
    case (a, b, c) => assert(a == "hello")
    case _ =>
  }

  // typed patterns
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ =>  -1
  }
  assert(generalSize("hello") == 5)
  assert(generalSize(Map("Orinda" -> "CA", "Boston" -> "MA", "Austin" -> "TX")) == 3)
  assert(generalSize(100) == -1)

  println("localhost: " + java.net.InetAddress.getLocalHost.getHostAddress)
}
