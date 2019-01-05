import scala.collection.mutable

object Copier {
  def copy[T](dest: mutable.Seq[T], src: mutable.Seq[T]): Unit = {
    require(dest.length >= src.length)
    var index = 0
    src.foreach(elem => {
      dest.update(index, elem)
      index += 1
    })
  }
}
