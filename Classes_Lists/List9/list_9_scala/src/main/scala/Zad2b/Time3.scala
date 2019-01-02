package Zad2b

class Time3(private var h: Int, private var m: Int) {
  require(h >= 0 && h < 24)
  require(m >= 0 && m < 60)

  private var minutesAfterMidnight: Int = h * 60 + m

  def hour: Int = minutesAfterMidnight / 60

  def hour_=(newHour: Int): Unit = {
    require(newHour >= 0 && newHour < 24)
    minutesAfterMidnight = newHour * 60 + m
  }

  def minute: Int = minutesAfterMidnight % 60

  def minute_=(newMinute: Int): Unit = {
    require(newMinute >= 0 && newMinute < 60)
    minutesAfterMidnight = h * 60 + newMinute
  }

  def before(other: Time3): Boolean = {
    minutesAfterMidnight < other.minutesAfterMidnight
  }
}
