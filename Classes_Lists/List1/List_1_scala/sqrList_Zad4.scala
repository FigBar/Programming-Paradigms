def sqrList (l1: List[Int]): List[Int] = {
    if(l1 == Nil) List()
    else (l1.head*l1.head)::sqrList(l1.tail)
}
