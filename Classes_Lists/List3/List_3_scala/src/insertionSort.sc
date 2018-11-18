

def insertionSort[A](order: A => A => Boolean)(xs: List[A]): List[A] = {
  def insert(elem: A)(accList: List[A]): List[A] =
    accList match {
      case Nil => elem :: Nil
      case h :: t => if (order(elem)(h)) elem :: accList
      else h :: insert(elem)(t)
    }

  xs.foldLeft(List[A]())((acc: List[A], elem: A) => insert(elem)(acc))
}

def increasingOrder(x: Int)(y: Int): Boolean = x <= y

insertionSort(increasingOrder)(List(4, 5, 1, 100, 1, 6, 9, 21, 14, 4))
