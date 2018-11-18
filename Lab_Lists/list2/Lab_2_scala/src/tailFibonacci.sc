import scala.annotation.tailrec

def tailFibonacciCall(n: Int): Int = {
  @tailrec
  def tailFibi(i: Int, actual: Int, next: Int): Int = {
    if (i == n) actual
    else tailFibi(i + 1, next, actual + next)
  }
  tailFibi(0, 0, 1)
}

tailFibonacciCall(0)
tailFibonacciCall(1)
tailFibonacciCall(2)
tailFibonacciCall(3)
tailFibonacciCall(4)
tailFibonacciCall(5)
tailFibonacciCall(6)
tailFibonacciCall(7)

