sealed trait BT[A]

case class Empty[A]() extends BT[A]

case class Node[A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

def internalPathSum[A](tt: BT[A]): Int = {
  def sumHelper(level: Int, subTree: BT[A]): Int = subTree match {
    case Empty() => 0
    case Node(_, left, right) => level + sumHelper(level + 1, left) + sumHelper(level + 1, right)
  }
  sumHelper(0, tt)
}

val tt = Node(1, Node(2, Node(4, Empty(), Empty()), Empty()), Node(3, Node(5, Empty(), Node(6, Empty(), Empty())), Empty()))
val myTree = Node(7,Node(1,Node(5, Empty(), Empty()),Node(2, Empty(), Empty())),Node(4, Node(9, Empty(), Empty()), Node(3, Empty(), Empty())))

internalPathSum(tt)
internalPathSum(myTree)