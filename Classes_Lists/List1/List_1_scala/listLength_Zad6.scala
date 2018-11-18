def listLength[Any] (l1: List[Any]): Int = {
    if(l1 == Nil) 0
    else 1 + listLength(l1.tail)
}
