import scala.collection.mutable.ListBuffer

object QueueTest {
  def main(args: Array[String]): Unit = {

    val queue1: TupleQueue[Int] = TupleQueue(1,2)
    val queue2 = queue1.enqueue(10)
    println(queue2.first)
    val queue3 = queue2.dequeue
    println(queue3.first)
    val queue4 = queue3.dequeue
    println(queue4.first)
    val queue5 = queue4.dequeue
    println(queue5.isEmpty)
    try {
      queue5.first
    } catch {
      case exc: TupleQueueException => println("The queue is empty!!!"); exc.printStackTrace()
    }
    println(TupleQueue.empty.isEmpty)

    var list1: ListBuffer[Int] = ListBuffer(1,2,3)
    var list2 = ListBuffer(4,5,6,7)
    Copier.copy(list2, list1)

    list2.foreach(elem => println(elem))
  }
}
