// companion object
// companion object and its class must be in the same source file. They can
// access each other's private members!

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s)) {
      println("found in cache")
      cache(s)
    } else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }
}

// val cs1 = ChecksumAccumulator.calculate("hello, world")
// println(s"cs1 is $cs1")
// val cs2 = ChecksumAccumulator.calculate("hello, world")
// println(s"cs2 is $cs2")
