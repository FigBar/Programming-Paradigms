def Fibonacci (n: Int): Int  = n match {
  case 0 => 0
  case 1 => 1
  case _ => Fibonacci(n-1) + Fibonacci(n-2)
}

Fibonacci(0)
Fibonacci(1)
Fibonacci(2)
Fibonacci(3)
Fibonacci(4)
Fibonacci(5)
Fibonacci(6)
Fibonacci(7)

Fibonacci(100)