def isATriangle(a: (Int, Int), b: (Int, Int), c: (Int, Int)): Boolean = {
  val matrix = (a._1 * b._2) + (b._1 * c._2) + (c._1 * a._2) - (c._1 * b._2) - (a._1 * c._2) - (a._2 * b._1)
  matrix != 0
}

isATriangle((0, 1), (0, 3), (0, 4))
isATriangle((1, 4), (4, 1), (1, 7))
isATriangle((1, 4), (1, 4), (2, 7))
isATriangle((1, 1), (2, 2), (3, 3))
isATriangle((1, 1), (1, 1), (1, 1))
isATriangle((2, 2), (1, 7), (2, 2))