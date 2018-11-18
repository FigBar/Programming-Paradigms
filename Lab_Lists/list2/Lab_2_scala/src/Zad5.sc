def findUnmatchedNumber(list: List[Int]) : Int = list match{
  case Nil => -1
  case hd::Nil => hd
  case hd::tl => hd^findUnmatchedNumber(tl)
}

findUnmatchedNumber(List(1,3,2,1,5,2,2,2,3))