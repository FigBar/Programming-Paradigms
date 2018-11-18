def sumProd(xs: List[Int]): (Int, Int) = xs.foldLeft(0, 1)((sp: (Int, Int), x: Int) => (sp._1 + x, sp._2 * x))


sumProd(List(1, 2, 3, 4))
sumProd(List())