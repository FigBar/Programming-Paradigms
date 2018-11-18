def count[A] (filter: A, l1: List[A]):Int = {
    if (l1 == Nil) 0
    else {
        if (l1.head == filter) 1 + count(filter, l1.tail)
        else count(filter, l1.tail)
    }
}

