package chapter13

// import package itself
import java.util.regex
import java.sql.{Date => SDate}
import java.{sql => S}
// import all members from Fruits except Pear
// import Fruits.{Pear => _, _}

// implicit imports
// The following is automatically imported
// import java.lang._
// import scala._
// import Predef._

// effects of private qualifiers
// no access qualifier          public access
// private[bobsrockets]         access up to package bobsrockets
// private[this]                object-private: access only from the same object

// package object
// name it "package.scala"
// Any definitions placed in a package object are considered members of the package itself.
/**
  * Created by jduan on 5/30/16.
  */
object Sandbox extends App {
  val pat = regex.Pattern.compile("a*b")
  assert(pat.matcher("aaaaab").matches())
}
