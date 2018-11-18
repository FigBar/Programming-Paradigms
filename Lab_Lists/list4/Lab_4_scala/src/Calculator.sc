import scala.Numeric.Implicits._

sealed trait Expression[T]

case class Value[T](value: T) extends Expression[T]

case class Neg[T](firVal: Expression[T]) extends Expression[T]

case class Sum[T](firVal: Expression[T], sndVal: Expression[T]) extends Expression[T]


def evalExpression[T: Numeric](exp: Expression[T]): T = exp match {
  case Value(value) => value
  case Sum(a, b) => evalExpression(a) + evalExpression(b)
  case Neg(a) => - evalExpression(a)
}




evalExpression(Neg(Value(10.231)))
evalExpression(Neg(Neg(Sum(Value(-231f), Value(207f)))))
evalExpression(Neg(Value(235)))