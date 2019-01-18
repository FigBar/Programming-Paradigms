package ping_pong

import akka.actor.{Actor, ActorRef, Props}



class Player(msg: String) extends Actor {
  override def receive: Receive = {
    case Player.StartGame(bounceLeft, coPlayer) =>
      println("Starting the match" + "\n" +  msg)
      coPlayer ! Player.InGame(bounceLeft - 1)

    case Player.InGame(bounceLeft) =>
      if (bounceLeft <= 0) {
        println("Ending the match")
        context.system.terminate
      } else {
        println(msg)
        sender ! Player.InGame(bounceLeft - 1)
      }
  }
}

object Player {
  def props(msg: String) = Props(classOf[Player], msg)

  case class StartGame(bounceLeft: Int, coPlayer: ActorRef)

  case class InGame(bounceLeft: Int)
}
