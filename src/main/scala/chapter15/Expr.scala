package chapter15

/**
  * Created by jduan on 5/30/16.
  */
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object ExprMain extends App {
  // pattern matching
  def simplify(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-",  e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("-", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case BinOp("/", e, Number(1)) => e
    // with the catch-all, you might get a MatchError
    case _ => expr
  }

  // factory method
  val v = Var("x")
  val op = BinOp("+", Number(1), v)

  // all arguments in the parameter list implicitly get a val prefix
  assert(v.name == "x")
  assert(op.left == Number(1))

  // natural toString representation
  println(op)

  // copy method
  val op2 = op.copy(operator = "-")
  assert(op2.operator == "-")
  assert(op2.left == Number(1))
  assert(op2.right == Var("x"))

  // pattern matching
  assert(simplify(UnOp("-", UnOp("-", Var("x")))) == Var("x"))
}
