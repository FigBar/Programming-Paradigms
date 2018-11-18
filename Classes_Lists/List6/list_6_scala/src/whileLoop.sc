def whileLoop(condition: => Boolean)(expr: => Unit): Unit = {
  if(condition){
    expr
    whileLoop(condition)(expr)
  }
}

var x = 0

whileLoop(x<=10)(x+=1)

x