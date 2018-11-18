def listContains[A](toCheck: List[A], filter: A): Boolean = {
  if (toCheck == Nil) false
  else if (toCheck.head == filter) true
  else listContains(toCheck.tail, filter)
}



def deleteIfContains[A](list: List[List[A]], filter: A): List[List[A]] = {
  if (list == Nil) Nil
  else if (listContains(list.head, filter)) deleteIfContains(list.tail, filter)
  else list.head :: deleteIfContains(list.tail, filter)

}

deleteIfContains(List(List("ala", "ma", "kota"), List("ala")), "ala")
deleteIfContains(List(List("ala", "ma", "kota"), List("ala"), List("kota"), List("ma")), "ala")
deleteIfContains(List(), "something")