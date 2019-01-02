package Zad2

object Time2Test {
  def main(args: Array[String]): Unit = {
    var time1 = new Time2(21, 15)
    println(time1.hour)
    println(time1.minute)
    time1.minute = 24
    println(time1.hour)
    println(time1.minute)

    var time2 = new Time2(8, 21)

    println(time1.before(time2))
    println(time2.before(time1))
  }
}
