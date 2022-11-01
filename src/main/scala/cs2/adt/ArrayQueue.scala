package cs2.adt

class ArrayQueue[A : Manifest] extends Queue[A] {
  private var arr:Array[A] = Array.ofDim[A](10)
  private var beg:Int = 0
  private var len:Int = 0
  
  def enqueue(elem:A):Unit = {
    if(len == arr.length) {
      val tmp = Array.ofDim[A](len * 2)
      for(i <- 0 until len) {
        tmp(i) = arr((beg + i) % arr.length)
      }
      beg = 0
      arr = tmp
    }
    arr((beg + len) % arr.length) = elem
    len += 1
  }
  def dequeue():A = {
    if(isEmpty()) {
      throw new QueueEmptyException//("Trying to dequeue from an empty Queue")
    }
    val result = arr(beg)
    beg = (beg + 1) % arr.length
    len -= 1
    result
  }
  def peek():A = { 
    if(isEmpty()) {
      throw new QueueEmptyException
    }
    arr(beg)
  }
  def isEmpty():Boolean = { len == 0 }
}

class QueueEmptyException extends Exception() {

}
