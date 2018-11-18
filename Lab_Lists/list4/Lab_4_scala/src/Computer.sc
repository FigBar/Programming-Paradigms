sealed trait Computer
case class MyComputer(components: List[Boolean]) extends Computer

val computer1 = MyComputer(List(true, false, true, false, false))

def computerContains (computer: MyComputer, index: Int):Boolean = {
  if(index >= 0 && index < computer.components.length) computer.components(index)
  else throw new Exception("You provided invalid number of component")
}

computerContains(computer1, 2)
computerContains(computer1, -4)