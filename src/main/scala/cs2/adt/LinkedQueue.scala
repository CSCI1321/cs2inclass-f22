package cs2.adt

class LinkedQueue[A] extends Queue[A] {
  private class Node(val data:A, var next:Node)
  private var head:Node = null
  private var last:Node = null

  def enqueue(elem:A):Unit = {
    if(isEmpty) {
      last = new Node(elem, null)
      head = last
    } else {
      last.next = new Node(elem, null)
      last = last.next
    }
  }
  def dequeue():A = {
    val tmp:A = head.data
    head = head.next
    if(head == null) {
      last = null
    }
    tmp
  }
  def peek():A = {
    head.data
  }

  def isEmpty():Boolean = {
    head == null && last == null
  }



}