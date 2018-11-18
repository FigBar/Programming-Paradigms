def root3(x: Double): Double = {
  def insideRoot(x: Double, xi: Double, precision: Double): Double ={
    val finish = Math.abs(Math.pow(xi, 3) - x) <= (precision * Math.abs(x))
    if(finish) xi else insideRoot(x, xi + (x/Math.pow(xi,2) - xi)/3, precision)
  }
  val initial = if (x <= 1) x else x/3
  insideRoot(x, initial, Math.pow(10, -15))
}

root3(9)