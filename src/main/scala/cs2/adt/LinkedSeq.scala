package cs2.adt

class LinkedSeq[A] extends Seq[A] with Iterable[A] {
  private class Node(var data:A, var next:Node)
  private var hed:Node = null
  private var len = 0

  def iterator:Iterator[A] = {
    new Iterator[A]() {
      var curr:Node = hed
      def next():A = {
        val ret = curr.data
        curr = curr.next
        ret
      }
      def hasNext:Boolean = {
        curr != null
      }
    }
  }


  private def getNode(idx:Int):Node = {
    var rover = hed
    for(i <- 0 until idx) {
      rover = rover.next
    }
    rover
  }

  def get(idx:Int):A = {
    if(idx < 0 || idx >= length()) {
      throw new IndexOutOfBoundsException()
    }
    val puppy = getNode(idx)
    puppy.data
  }
  def set(idx:Int, elem:A):Unit = {
    if(idx < 0 || idx >= length()) {
      throw new IndexOutOfBoundsException()
    }
    val rover = getNode(idx)
    rover.data = elem
  }
  def insert(idx:Int, elem:A):Unit = {
    if(idx < 0 || idx > length()) {
      throw new IndexOutOfBoundsException()
    }
    if(idx == 0) {
      hed = new Node(elem, hed)
    } else {
      val rover = getNode(idx - 1)
      rover.next = new Node(elem, rover.next)
    }
    len += 1
  }
  def remove(idx:Int):A = {
    if(idx < 0 || idx >= length()) {
      throw new IndexOutOfBoundsException()
    }
    len -= 1
    if(idx == 0) {
      val ret = hed.data
      hed = hed.next
      ret
    } else {
      val rover = getNode(idx - 1)
      val ret = rover.next.data
      rover.next = rover.next.next
      ret
    }
  }
  def length():Int = len
}