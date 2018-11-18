def greaterThan (n: Int, list: List[Int]) : List [Int] = {
  if (list.isEmpty) List()
  else if (list.head > n) {
    list.head :: greaterThan(n, list.tail)
  } else {
    greaterThan(n, list.tail)
  }
}

greaterThan(5, List(55,1,2,4,-7, 6, 5 ))
greaterThan(0, List())