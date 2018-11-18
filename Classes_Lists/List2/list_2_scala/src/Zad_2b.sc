def tailFibonacciCall (n : Int) : Int = {
  def tailFibi (n: Int, prevValue: Int, prePrevValue: Int) : Int = n match {
    case 0 => prevValue
    case _ => tailFibi(n-1, prePrevValue + prevValue, prevValue)
  }

  tailFibi(n, 1, 0)
}

tailFibonacciCall(0)
tailFibonacciCall(1)
tailFibonacciCall(2)
tailFibonacciCall(3)
tailFibonacciCall(4)
tailFibonacciCall(5)
tailFibonacciCall(6)