package ping_pong

import akka.actor.ActorSystem

object Match {
  def main(args: Array[String]): Unit = {
    val Match = ActorSystem("Match")
    val ping = Match.actorOf(Player.props("Ping"))
    val pong = Match.actorOf(Player.props("Pong"))
    ping ! Player.StartGame(10, pong)
  }
}
