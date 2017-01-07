/**
  * Created by jduan on 6/12/16.
  */
trait Box[T] {

  def put(t: T)

  def get: T
}

trait CanBePacked

trait Furniture extends CanBePacked

trait Books extends CanBePacked

def packFurnitureIntoBox(b: Box[CanBePacked]) = {
  // work hard to pack things
}

val bBox: Box[Books] = new Box[Books] {
  override def put(t: Books): Unit = ???

  override def get: Books = ???
}

// disallowed
// packFurnitureIntoBox(bBox)