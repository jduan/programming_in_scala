// create an array of Strings
val greetStrings = new Array[String](3)
// val greetStrings: Array[String] = new Array[String](3)

// use () to access array elements
val g0 = greetStrings(0)
// this is equivalent to the following
val g0 = greetStrings.apply(0)

// use ()= to assignment to array elements
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"
// this is equivalent to the following
greetStrings.update(2, "world!\n")

// for (i <- 0 to 2)
//   print(greetStrings(i))

// for (i <- 0 until greetStrings.length)
//   print(greetStrings(i))

// for (s <- greetStrings)
//   print(s)

// all operators are method calls
1 + 2 == (1).+(2)

// Scala achieves a conceptual simplicity by treating everything, from arrays to
// expressions, as objects with methods. You don't have to remember special
// cases, such as the differences in Java between primitive and their
// corresponding wrapper types, or between arrays and regular objects.

// another way of creating arrays (use the Array companion object)
// type: Array[String]
val numbers = Array("zero", "one", "two")
val numbers = Array.apply("zero", "one", "two")

// create a list using the List companion object
val lst1 = List(1,2,3)
val lst2 = List(4,5,6)
lst1 ::: lst2 // concatenate
// rule of thumb: if a method name ends in a colon, the method is invoked on the
// right object
1 :: lst1 // cons: prepend 1 to lst1
lst1.::(1) // equivalent
1 :: 2 :: 3 :: Nil == List(1,2,3)
lst1(1) // access
List() == Nil // true

// tuple
val pair = (99, "hello") // type: Tuple2(Int, String)
// You can't do pair(1) because a list's apply method always returns the same
// type, but each element of a tuple may be a different type.
pair._1
pair._2

// sets
// scala contains a base trait for sets, then provides two subtraits, one
// for mutable sets and another for immutable sets.
// scala.collection.Set
// scala.collection.immutable.Set
// scala.collection.immutable.HashSet
// scala.collection.mutable.Set
// scala.collection.mutable.HashSet

// maps
// scala.collection.Map
// scala.collection.immutable.Map
// scala.collection.immutable.HashMap
// scala.collection.mutable.Map
// scala.collection.mutable.HashMap

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

// 1 -> "Go to island." is equivalent to (1).->("Go to island.")
// This -> method, which you can invoke on any object in scala, returns a
// two-element tuple.

val romanNumeral = Map(
  1 -> "I",
  2 -> "II",
  3 -> "III",
  4 -> "IV",
  5 -> "V")
println(romanNumeral.mkString("\n"))

// rule of thumb: if code contains any vars, it's probably an imperative style.
// If the code contains no vars at all, ie it contains only vals, it is probably
// in a functional style. One way to move towards a functional style, therefore,
// is to try to program without vars.
//
// A balanced attitude for scala programmers
// Prefer vals, immutable objects, and methods without side effects. Reach for
// them first. Use vars, mutable objects, and methods with side effects when you
// have a specific need and justification for them.
