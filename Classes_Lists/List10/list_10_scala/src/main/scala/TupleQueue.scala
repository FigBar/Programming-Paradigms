class TupleQueueException(message: String) extends Exception(message)


class TupleQueue[+T](private val queueTup: (List[T], List[T])) {

  def enqueue[S >: T](element: S): TupleQueue[S] = {
    queueTup match {
      case (Nil, _) => new TupleQueue[S](List[S](element), Nil)
      case (left, right) => new TupleQueue[S](left, element :: right)
    }
  }

  def dequeue: TupleQueue[T] =
    queueTup match {
      case (List(_), right) => new TupleQueue[T](right.reverse, Nil)
      case (_ :: tl, right) => new TupleQueue[T](tl, right)
      case (Nil, _) => new TupleQueue[T](Nil, Nil)
    }

  def first: T =
    queueTup._1 match {
      case hd :: _ => hd
      case Nil => throw new TupleQueueException("first")
    }

  def isEmpty: Boolean =
    queueTup._1 == Nil

  object TupleQueue {
    def apply[S >: T](xs: S*): TupleQueue[S] = new TupleQueue[S](xs.toList, Nil)

    def empty[S >: T]: TupleQueue[S] = new TupleQueue[S](Nil, Nil)
  }

}
