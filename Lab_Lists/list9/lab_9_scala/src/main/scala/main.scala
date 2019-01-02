abstract class Vehicle {
  def name: String
}

case class Car(name: String) extends Vehicle

case class Motorcycle(name: String) extends Vehicle

abstract class Workshop[-A] {
  def repair(vehicle: A): Unit
}

class VehicleWorkshop extends Workshop[Vehicle] {
  override def repair(vehicle: Vehicle): Unit = {
    println("Vehicle: " + vehicle.name + " has been repaired")
  }
}

class CarWorkshop extends Workshop[Car] {
  override def repair(vehicle: Car): Unit = {
    println("Car: " + vehicle.name + " has been repaired")
  }
}

class SpecificVehicleGarage[A](vehicle: A) {
  private var holdVehicle: A = vehicle
  def getVehicle: A = holdVehicle
  def setVehicle(vehicle: A):Unit = {
    holdVehicle = vehicle
  }
}

object CovarTest {
  def printVehicles(vehicles: List[Vehicle]): Unit = {
    vehicles.foreach { vehicle => println(vehicle.name) }
  }
}

object ContravarTest {
  def printMyCar(printer: Workshop[Car], car: Car): Unit = {
    printer.repair(car)
  }
}

object main {
  def main(args: Array[String]): Unit = {
    val cars: List[Car] = List(Car("Ferrari"), Car("Bugatti"))
    val motorcycles: List[Motorcycle] = List(Motorcycle("Kawasaki"), Motorcycle("Suzuki"))
    println("Covariance example: ")
    CovarTest.printVehicles(cars)
    CovarTest.printVehicles(motorcycles)

    println()
    val carWorkshop : Workshop[Car] = new CarWorkshop
    val vehicleWorkshop : Workshop[Vehicle] = new VehicleWorkshop
    val car1 : Car = Car("Volkswagen")
    println("Contravariance example: ")
    ContravarTest.printMyCar(carWorkshop, car1)
    ContravarTest.printMyCar(vehicleWorkshop, car1)

    println("\n" + "Invariance test")
    val carGarage: SpecificVehicleGarage[Car] = new SpecificVehicleGarage[Car](Car("Porshe"))
    //carGarage.setVehicle(Motorcycle("Yamaha"))

  }

}

