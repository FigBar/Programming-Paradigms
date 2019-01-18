package ball_match

import akka.actor.{ActorRef, ActorSystem}

object Match {
  def main(args: Array[String]): Unit = {
    val Match = ActorSystem("Match")
    var players: Array[ActorRef] = Array()
    val p1 = Match.actorOf(Player.props(1, "player", players))
    val p2 = Match.actorOf(Player.props(2, "player", players))
    val p3 = Match.actorOf(Player.props(3, "player", players))
    players = Array(p1, p2, p3)
    p1 ! Player.StartGame
  }

}
