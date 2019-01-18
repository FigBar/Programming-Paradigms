package ball_match

import akka.actor.{ActorRef, ActorSystem, Props}

object Match {
  def main(args: Array[String]): Unit = {
    val Match = ActorSystem("Match")
    var players: Array[ActorRef] = Array()
    val p1 = Match.actorOf(Props(new Player(0, "player", players)))
    val p2 = Match.actorOf(Props(new Player(1, "player", players)))
    val p3 = Match.actorOf(Props(new Player(2, "player", players)))
    players = Array(p1, p2, p3)
    p1 ! Player.StartGame
  }
}
