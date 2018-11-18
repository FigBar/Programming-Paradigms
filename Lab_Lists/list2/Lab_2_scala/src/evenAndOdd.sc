import scala.annotation.tailrec

def evenAndOdd (list: List[Int]): (List[Int], List[Int], List[Int]) = {
  @tailrec
  def innerEvenAndOdd(given: List[Int], outcome: (List[Int], List[Int], List[Int])): (List[Int], List[Int], List[Int]) = {
    given match {
      case Nil => (outcome._1.reverse, outcome._2.reverse, outcome._3.reverse)
      case hd::tl =>
        if(hd%2==0) innerEvenAndOdd(tl, (hd::outcome._1, outcome._2, outcome._3))
        else if (hd > 0) innerEvenAndOdd(tl, (outcome._1, hd::outcome._2, outcome._3))
        else innerEvenAndOdd(tl, (outcome._1,outcome._2, hd::outcome._3))
    }
  }
  innerEvenAndOdd(list, (List[Int](), List[Int](), List[Int]()))
}

evenAndOdd(List(3,-3,4,2,1,-7, -4, 0))
evenAndOdd(List())
evenAndOdd(List(-1,0,7))