
object QueueTest {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(5)
    val queue1: TupleQueue[Int] = new TupleQueue[Int](list, Nil)
    val queue2 = queue1.enqueue(10)
    println(queue2.first)
    val queue3 = queue2.dequeue
    println(queue3.first)
    val queue4 = queue3.dequeue
    println(queue4.isEmpty)
    println(queue2.TupleQueue.empty.isEmpty)





  }
}