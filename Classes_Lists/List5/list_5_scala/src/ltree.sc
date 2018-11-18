sealed trait lBT[+A]

case object LEmpty extends lBT[Nothing]

case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]


def ltree(n: Int): lBT[Int] = {
  LNode(n, () => ltree(2 * n), () => ltree(2 * n + 1))
}

def toStream[A](tt: lBT[A]): Stream[A] = {
  def innerToStream(subTreeQueue: List[lBT[A]]): Stream[A] = subTreeQueue match {
    case Nil => Stream.Empty
    case LEmpty :: tail => innerToStream(tail)
    case LNode(elem, left, right) :: tail => elem #:: innerToStream(tail ++ List(left(), right()))
  }
  innerToStream(List(tt))
}


toStream(ltree(10)).take(10).force