package ball_match

import akka.actor.{ActorRef, ActorSystem, Props}

object Match {
  def main(args: Array[String]): Unit = {
    val Match = ActorSystem("Match")
    var players: Array[ActorRef] = Array()
    val p1 = Match.actorOf(Player.props(0, "player"))
    val p2 = Match.actorOf(Player.props(1, "player"))
    val p3 = Match.actorOf(Player.props(2, "player"))
    players = Array(p1, p2, p3)
    p1 ! Player.JoinGame(players)
    p2 ! Player.JoinGame(players)
    p3 ! Player.JoinGame(players)
    p1 ! Player.StartGame
  }
}
