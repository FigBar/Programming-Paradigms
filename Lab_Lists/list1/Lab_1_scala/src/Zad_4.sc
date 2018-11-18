def decreasing (el1: Int, el2: Int, el3: Int) = (el3 < el2) && (el2 < el1)



def decreasingOrder (list: List[Int]) : Boolean = {
  if(list == Nil) true
  else {
    if (list.tail == Nil) true
    else if (list.head < list.tail.head) false
    else
      decreasingOrder(list.tail)
  }
}
decreasingOrder(List(1,2,3,4))
decreasingOrder(List(3,2,1))
decreasingOrder(List(1,7,6))
decreasingOrder(List())
decreasingOrder(List(-1))

decreasing(3,2,1)
decreasing(1,2,3)
decreasing(1,1,1)
decreasing(1,0,-1)