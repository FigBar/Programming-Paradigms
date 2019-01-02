package Zad3

class Pojazd(val producent: String, val model: String, val rokProdukcji: Int = -1, var numerRejestracyjny: String = "") {
  def this(producent: String, model: String, numerRejestracyjny: String){
    this(producent, model, -1, numerRejestracyjny)
  }
}
