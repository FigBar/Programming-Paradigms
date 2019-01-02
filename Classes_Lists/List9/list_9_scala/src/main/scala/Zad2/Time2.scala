package Zad2

class Time2(private var h: Int, private var m: Int) {
  require(h >= 0 && h < 24)
  require(m >= 0 && m < 60)

  def hour: Int = h

  def hour_=(newHour: Int): Unit = {
    require(newHour >= 0 && newHour < 24)
    h = newHour
  }

  def minute: Int = m

  def minute_=(newMinute: Int): Unit = {
    require(newMinute >= 0 && newMinute < 60)
    m = newMinute
  }

  def before(other: Time2): Boolean = {
    if (h == other.h) m < other.m
    else h < other.h
  }
}
