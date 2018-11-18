def initSegment[A] (segment: List[A], list: List[A]): Boolean = (segment, list) match {
  case (Nil , _) => true
  case(_, Nil) => false
  case(h1::t1, h2::t2) => if (h1 == h2) initSegment(t1, t2) else false
}

initSegment(Nil, Nil) //true
initSegment(Nil, List("ala", "ma", "kota")) //true
initSegment(List("ala", "ma"), Nil) // false
initSegment(Nil, List("ala", "ma", "kota")) // true
initSegment(List("ala", "ma", "kota"), List("ala", "ma", "kota")) //true
initSegment(List("ala", "ma", "kota"), List("ala", "ma")) // false
initSegment(List("ala", "ma"), List("ala", "ma", "kota")) // true