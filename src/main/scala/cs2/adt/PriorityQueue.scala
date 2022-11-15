package cs2.adt

//Bound restriction A must inherit from Ordered[A]
//meaning it will have < > <= >=
abstract class PriorityQueue[A <% Ordered[A]] {
  def add(elem:A):Unit
  def get():A
  def peek():A
  def isEmpty():Boolean
}