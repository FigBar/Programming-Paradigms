def lRepeat[A](k: Int)(llist: Stream[A]): Stream[A] = {
  def innerRepeat(n: Int)(newList: Stream[A]): Stream[A] = newList match {
    case Stream.Empty => Stream.Empty
    case x #:: xf => if (n == 0) innerRepeat(k)(xf)
    else x #:: innerRepeat(n - 1)(newList)
  }

  innerRepeat(k)(llist)
}

lRepeat(3)(Stream.from(3)).take(10).force