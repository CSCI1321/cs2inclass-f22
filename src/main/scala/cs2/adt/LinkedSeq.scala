package cs2.adt

class LinkedSeq[A] extends Seq[A] {
  private class Node(var data:A, var next:Node)
  private var head:Node = null

  private def getNode(idx:Int):Node = {
    var rover = head
    for(i <- 0 until idx) {
      rover = rover.next
    }
    rover
  }

  def get(idx:Int):A = {
    val rover = getNode(idx)
    rover.data
  }
  def set(idx:Int, elem:A):Unit = {
    val rover = getNode(idx)
    rover.data = elem
  }
  def insert(idx:Int, elem:A):Unit = {
    val rover = getNode(idx - 1)
    rover.next = new Node(elem, rover.next)
  }
  def remove(idx:Int):A = ???
  def length():Int = ???
}