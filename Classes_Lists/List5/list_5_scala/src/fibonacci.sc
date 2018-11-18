
val fibonacci = {
  def generateFib(a: Int)(b: Int): Stream[Int] = {
    a#::generateFib(b)(a+b)
  }
  generateFib(1)(1)
}

fibonacci.take(20).force