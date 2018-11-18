sealed trait Graphs[A]
case class Graph[A](succ: A => List[A]) extends Graphs[A]


def depthSearch[A](g: Graph[A])(startNode: A): List[A] = {
  def innerSearch(visited: List[A])(toVisit: List[A]): List[A] = toVisit match {
    case Nil => Nil
    case h::t =>
      if(visited contains h) innerSearch(visited)(t)
      else h::innerSearch(h::visited)((g succ h) ++ t)
  }
  innerSearch(List())(List(startNode))
}

val g = Graph((i: Int) => i match {
  case 0 => List(3)
  case 1 => List(0,2,4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0,2)
  case n => throw new Exception("Graph g: node " + n + " doesn't exist")
})

depthSearch(g)(4)
depthSearch(g)(3)
depthSearch(g)(0)
depthSearch(g)(2)
depthSearch(g)(1)
depthSearch(g)(10)