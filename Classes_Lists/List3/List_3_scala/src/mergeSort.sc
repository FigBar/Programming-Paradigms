def mergesort[A](order: A => A => Boolean)(xs: List[A]): List[A] = {
  val partition = xs.length / 2
  if (partition == 0) xs
  else {
    def merge(xs1: List[A], xs2: List[A]): List[A] = (xs1, xs2) match {
      case (Nil, l2) => l2
      case (l1, Nil) => l1
      case (h1 :: t1, h2 :: t2) =>
        if (order(h1)(h2)) h1 :: merge(t1, xs2)
        else h2 :: merge(xs1, t2)
    }

    val (leftPart, rightPart) = xs.splitAt(partition)
    merge(mergesort(order)(leftPart), mergesort(order)(rightPart))
  }
}

def increasingOrder(x: Int)(y: Int): Boolean = x <= y

mergesort(increasingOrder)(List(345, 971, 3, 3, 5, 4, 2, 6, 7, 5, 2, 4, 55, 34, 6, 7, 22, 54, 37, 85))