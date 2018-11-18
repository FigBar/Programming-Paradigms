import scala.annotation.tailrec

def convertFromBinary(binaryList: List[Int]): Int = {
  @tailrec
  def innerConverter(accu: Int, list: List[Int]): Int = {
    if (list == Nil) accu
    else if (list.head == 0 || list.head == 1) innerConverter(accu + list.head * Math.pow(2, list.length - 1).toInt, list.tail)
    else throw new RuntimeException("The number is not binary")
  }

  innerConverter(0, binaryList)
}

convertFromBinary(List(1, 0, 1))
convertFromBinary(List())
convertFromBinary(List(1, 1, 1))
convertFromBinary(List(1, 2, 3))