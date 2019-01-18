package ping_pong

import akka.actor.{Actor, ActorRef, Props}
import ping_pong.Player.InGame

class Player(msg: String) extends Actor {

  override def receive: Receive = {
    case Player.StartGame(bounceLeft, coPlayer) =>
      println(msg)
      coPlayer ! Player.InGame(bounceLeft - 1)

    case Player.InGame(bounceLeft) =>
      if (bounceLeft <= 0) context.system.terminate
      else {
        println(msg)
        sender ! InGame(bounceLeft - 1)
      }
  }

}

object Player {
  def props(msg: String) = Props(classOf[Player], msg)

  case class StartGame(bounceLeft: Int, coPlayer: ActorRef)

  case class InGame(bounceLeft: Int)

}
