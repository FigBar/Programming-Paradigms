package Zad4

object UzycieWyjatkow {
    def main(args: Array[String]): Unit = {
      try {
        this.metoda1
      } catch {
        case ex: Exception => ex.printStackTrace()
      }
    }

    def metoda1: Unit = {
      metoda2
    }

    def metoda2: Unit = {
      metoda3
    }

    @throws
    def metoda3: Unit = {
      throw new Exception("Wyjatek zgloszony w metoda 3")
    }
}
