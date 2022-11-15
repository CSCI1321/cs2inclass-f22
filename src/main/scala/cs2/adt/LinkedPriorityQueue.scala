package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node(var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = {
    if(head == null || elem > head.data) {
      head = new Node(elem, head)
    } else {
      var rover = head
      while(rover.next != null && rover.next.data > elem) {
        rover = rover.next
      }
      rover.next = new Node(elem, rover.next)
    }
  }
  def get():A = {
    val ret = head.data
    head = head.next
    ret
  }
  def peek():A = { head.data }
  def isEmpty():Boolean = { head == null }

  /*
  def add(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def get():A = {
    var rover = head
    var slowRover:Node = null
    var largest:A = head.data
    var obl:Node = null

    while(rover != null) {
      if(rover.data > largest) {
        largest = rover.data
        obl = slowRover
      }
      slowRover = rover
      rover = rover.next
    }
    if(obl == null) {
      head = head.next
    } else {
      obl.next = obl.next.next
    }
    largest
  }
  def peek():A = {
    var rover = head
    var largest:A = head.data
    while(rover != null) {
      if(rover.data > largest) largest = rover.data
      rover = rover.next
    }
    largest
  }
  def isEmpty():Boolean = { head == null }
  */
}