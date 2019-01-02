package Zad1

object TimeTest {
  def main(args: Array[String]): Unit = {
    var time1 = new Time(23)
    println(time1.hour)
    time1.hour = 24
    println(time1.hour)
    time1.hour = -1
    println(time1.hour)
    var time2 = Time(5)
    println(time2.hour)
  }
}
