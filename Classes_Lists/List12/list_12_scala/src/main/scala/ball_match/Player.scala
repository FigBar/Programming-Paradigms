package ball_match

import akka.actor.{Actor, ActorRef, Props}

import scala.util.Random

class Player(index: Int, name: String) extends Actor {

  private val getRandomPlayer = new Random
  private var players: Array[ActorRef] = Array()

  override def receive: Receive = {
    case Player.JoinGame(players) =>
      this.players = players

    case Player.StartGame =>
      println(name + " " + index + " starts the game.")
      randomPlayer ! Player.Ball(1)

    case Player.Ball(count) =>
      println(name + " " + index + " kicks " + count + " time.")
      randomPlayer ! Player.Ball(count + 1)
  }

  private def randomPlayer(): ActorRef = {
    var drawnIndex = index
    do {
      drawnIndex = getRandomPlayer.nextInt(players.length)
    } while (drawnIndex == index)
    players(drawnIndex)
  }
}

object Player {

  def props(index: Int, name: String) = Props(classOf[Player], index, name)

  case class Ball(count: Int)

  case class JoinGame(players: Array[ActorRef])

  case object StartGame

}
