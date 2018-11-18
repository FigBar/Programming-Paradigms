def sumList (list: List[Double]) : Double = {
  if (list == Nil) 0
  else
    list.head + sumList(list.tail)
}

def sum2List (list: List[Double]) : Double = list match  {
    case Nil => 0
    case head::tail => head + sum2List(tail)
}
sumList(List(4,6,4,3,8))
sumList(List())
sumList(List(-10, 12, 4, -71))
sumList(List(0))
