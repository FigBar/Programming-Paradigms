def curry3[A, B, C, D](fun: (A, B, C) => D): A => B => C => D =
  (x: A) => (y: B) => (z: C) => fun(x, y, z)

def substract(x: Int, y: Int, z: Int): Int = {
  x - y - z
}

substract(1, 2, 3)

val f1 = curry3(substract)

f1(1)(2)(3)

def uncurry3[A, B, C, D](fun: A => B => C => D): (A, B, C) => D =
  (x: A, y: B, z: C) => fun(x)(y)(z)

def add(x: Int)(y: Int)(z: Int): Int = {
  x + y + z
}

add(1)(2)(3)

val f2 = uncurry3(add)

f2(1, 2, 3)