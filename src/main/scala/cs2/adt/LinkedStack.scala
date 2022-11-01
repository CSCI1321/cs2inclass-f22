package cs2.adt

import java.util.EmptyStackException

class LinkedStack[A] extends Stack[A] {
  private class Node(val data:A, var next:Node)
  private var head:Node = null

  def push(elem:A):Unit = ???
  def pop():A = ???
  def peek():A = {
    if(isEmpty) throw new EmptyStackException()

    ???
  }
  def isEmpty():Boolean = { head == null }
}