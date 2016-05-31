/**
  * This snippet demonstrates "traits as stackable modifications"
  */
package chapter12

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jduan on 5/30/16.
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()

  def get(): Int = buf.remove(0)

  def put(x: Int): Unit = buf += x
}

// "extends IntQueue" means this trait can only be mixed into a class that also extends IntQueue
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

object Main2 extends App {
  val queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)
  assert(queue.get() == 10)
  assert(queue.get() == 20)

  val mq = new MyQueue
  mq.put(10)
  mq.put(20)
  assert(mq.get() == 20)
  assert(mq.get() == 40)

  // create an object without a class
  val q3 = new BasicIntQueue with Doubling
  q3.put(10)
  q3.put(20)
  assert(q3.get() == 20)
  assert(q3.get() == 40)

  val q4 = new BasicIntQueue with Incrementing with Filtering
  q4.put(-1)
  q4.put(0)
  q4.put(1)
  assert(q4.get() == 1)
  assert(q4.get() == 2)

  // q5 differs from q4 in the order of the traits
  val q5 = new BasicIntQueue with Filtering with Incrementing
  q5.put(-1)
  q5.put(0)
  q5.put(1)
  assert(q5.get() == 0)
  assert(q5.get() == 1)
  assert(q5.get() == 2)
}
