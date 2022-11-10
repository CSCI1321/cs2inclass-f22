package cs2.adt

class DoublyLinkedSeq[A : Manifest] extends Seq[A] {
  private class Node(var data:A, var prev:Node, var next:Node)
  private var end:Node = new Node(Array.ofDim[A](1).apply(0), null, null)
  end.prev = end
  end.next = end
  private var len:Int = 0 

  private def getNode(idx:Int):Node = {
    if(idx < 0 || idx >= len) end
    else {
      var rover = end.next
      for(i <- 0 until idx) {
        rover = rover.next
      }
      rover
    }
  }
  def get(idx:Int):A = {
    if(idx < 0 || idx >= len) throw new IndexOutOfBoundsException()
    val rover = getNode(idx)
    rover.data 
  }
  def set(idx:Int, elem:A):Unit = {
    if(idx < 0 || idx >= len) throw new IndexOutOfBoundsException()
    val rover = getNode(idx)
    rover.data = elem
  }
  def insert(idx:Int, elem:A):Unit = { 
    val rover = getNode(idx - 1)
    len += 1
    rover.next = new Node(elem, rover, rover.next)
    rover.next.next.prev = rover.next
  }
  def remove(idx:Int):A = {
    if(idx < 0 || idx >= len) throw new IndexOutOfBoundsException()
    val rover = getNode(idx)
    len -= 1
    val ret = rover.data
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
    ret
  }
  def length():Int = len
}