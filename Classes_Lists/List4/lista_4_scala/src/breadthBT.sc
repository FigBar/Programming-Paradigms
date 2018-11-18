sealed trait BT[A]

case class Empty[A]() extends BT[A]

case class Node[A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

def breadthBT[A](tt: BT[A]): List[A] = {
  def innerBreadth(subTreeQueue: List[BT[A]]): List[A] = subTreeQueue match {
    case Nil => Nil
    case Empty() :: tail => innerBreadth(tail)
    case Node(elem, left, right) :: tail => elem :: innerBreadth(tail ++ List(left, right))
  }
  innerBreadth(List(tt))
}

val tt = Node(1, Node(2, Node(4, Empty(), Empty()), Empty()), Node(3, Node(5, Empty(), Node(6, Empty(), Empty())), Empty()))
val myTree = Node(7,Node(1,Node(5, Empty(), Empty()),Node(2, Empty(), Empty())),Node(4, Node(9, Empty(), Empty()), Node(3, Empty(), Empty())))

breadthBT(tt)
breadthBT(myTree)