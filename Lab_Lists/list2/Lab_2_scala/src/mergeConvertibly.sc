import scala.annotation.tailrec

def mergeConvertibly[A] (list1: List[A], list2: List[A]): List[A] = {
  @tailrec
  def innerMergeConvertibly[A](outcome: List[A], list1: List[A], list2: List[A]):List[A] =
    (list1, list2) match {
      case(Nil,Nil) => outcome.reverse
      case (hd::tl, secondList) => innerMergeConvertibly(hd::outcome, secondList, tl)
      case(Nil, secondList) => innerMergeConvertibly(outcome, secondList, Nil)
}
  innerMergeConvertibly(Nil, list1, list2)
}

mergeConvertibly(List(3,8,9), List(4,7,9))
mergeConvertibly(List(3,8,9), Nil)
mergeConvertibly(Nil, List(3,8,9))
mergeConvertibly(Nil, Nil)