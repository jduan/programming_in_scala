// packages automatically imported by scala
// 1. java.lang.*
// 2. scala.*
// 3. scala.Predef.*

// symbols
// scala.Symbol
// symbols are interned. If you write the same symbol literal twice, both
// expressions will refer to the exact same Symbol object.
val s = 'cymbal
val s2 = Symbol("cymbal")
println(s.name)

// string interpolation
val name = "reader"
println(s"Hello, $name!") // simple interpolation
println(s"The answer is ${6 * 7}.")
println(s"No\\\\escape!")
println(raw"No\\\\escape!") // raw interpolation
println(f"${math.Pi}%.5f")  // format interpolation

// operator notation, such as 1 + 2
// Operator notation is not limited to methods like + that look like operators
// in other languages. You can use *any* method in operator notation, such as
val s = "Hello, world!"
s indexOf 'o' // same as s.indexOf('o')
s indexOf ('o', 5)  // same as s.indexOf('o', 5)

// prefix notation
// the only identifiers that can be used as prefix operators are +, -, !, and ~
(2.0).unary_- // same as -2.0

// postfix notation
val s = "hello, world!"
s toLowerCase // same as s.toLowerCase
// In scala, you can leave off empty parentheses on method calls. The convention
// is that you include parentheses if the method has side effects, such as
// println(), but you can leave them off if the method has no side effects,
// such as String.toLowercase

// object equality
// == compares if two objects have the same values. The way it works is: first
// check the left side for null. If it's not null, call the equals method.
//
// For reference equality, use "eq". However, eq and its opposite, ne, only
// apply to objects that directly map to Java objects in the heap.
//
val lst1 = List(1,2,3)
val lst2 = List(1,2,3)
l1 == l2 // true
l1.equals(l2) // true
l1.eq(l2) // false

// rich wrappers, ie implicit conversions
// For each basic type, there is also a "rich wrapper" that provides additional
// methods.
//   Byte                  scala.runtime.RichByte
//   Short                 scala.runtime.RichShort
//   Int                   scala.runtime.RichInt
//   Long                  scala.runtime.RichLong
//   Char                  scala.runtime.RichChar
//   Float                 scala.runtime.RichFloat
//   Double                scala.runtime.RichDouble
//   Boolean               scala.runtime.RichBoolean
//   String                scala.collection.immutable.StringOps

// The main take-aways from this chapter are that operators in Scala are method
// calls, and that implicit conversions to rich variants exist for Scala’s basic
// types that add even more useful methods.
