class Rational(n: Int, d: Int) {
  // precondition, throws java.lang.IllegalArgumentException
  require(d != 0) // scala.Predef.require

  private val g = gcd(n.abs, d.abs)
  private val numer: Int = n / g
  private val denom: Int = d / g

  // auxiliary constructor
  // must invoke another constructor as its first action!
  def this(n: Int) = this(n, 1)

  // scala will compile any code you place in the class body, which isn't part
  // of a field or a method definition, into the primary constructor.
  println(s"Created $numer/$denom")

  override def toString = s"Rational($numer/$denom)"

  def +(other: Rational): Rational = {
    new Rational(
      // you can also write "this.numer"
      numer * other.denom + other.numer * denom,
      denom * other.denom
    )
  }

  def +(other: Int): Rational =
    new Rational(numer + denom * other, denom)

  def *(other: Rational): Rational = {
    new Rational(numer * other.numer, denom * other.denom)
  }

  def *(other: Int): Rational = {
    new Rational(numer * other, denom)
  }

  def lessThan(other: Rational) =
    this.numer * other.denom < other.numer * this.denom

  def max(other: Rational) =
    if (this.lessThan(other)) other else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// implicit conversions
// Given r1 = new Rational(1, 4), note that you can do this:
// 2 + r1
// but if you can if you add an implicit conversion:
// implicit def intoToRational(x: Int) = new Rational(x)
//
// For an implicit conversion to work, it needs to be in scope. If you place the
// implicit method definition inside class Rational, it won’t be in scope in the
// interpreter. For now, you’ll need to define it directly in the interpreter.


// a word of caution
// If used unartfully, both operator methods and implicit conversions can give
// rise to client code that is hard to read and understand. Because im- plicit
// conversions are applied implicitly by the compiler, not explicitly writ- ten
// down in the source code, it can be non-obvious to client programmers what
// implicit conversions are being applied. And although operator meth- ods will
// usually make client code more concise, they will only make it more readable
// to the extent client programmers will be able to recognize and re- member the
// meaning of each operator.
