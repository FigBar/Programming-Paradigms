def flattenList[A] (l1:List[List[A]]):List[A] = {
    if (l1 == Nil) List()
     else l1.head:::flattenList(l1.tail)
}

