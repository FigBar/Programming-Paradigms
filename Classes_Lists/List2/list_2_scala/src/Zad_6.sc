def replaceNth[A](list: List[A], n: Int, replace: A): List[A] = (list, n) match {
  case (Nil, _) => Nil
  case(hd::tl, 0) => replace::tl
  case(hd::tl, _) => hd::replaceNth(tl, n-1, replace)
}


replaceNth(List("just", "do", "it"), 1, "fuck")
replaceNth(List("just", "do", "it"), 6, "fuck")
replaceNth(List(), 3, "miro")