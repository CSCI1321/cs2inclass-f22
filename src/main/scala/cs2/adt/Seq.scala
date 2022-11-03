package cs2.adt

abstract class Seq[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A):Unit
  def insert(idx:Int, elem:A):Unit
  def remove(idx:Int):A
  def length():Int

  def prepend(elem:A):Unit = { insert(0, elem) }
  def += (elem:A):Unit = append(elem)
  def +:= (elem:A):Unit = prepend(elem)
  def append(elem:A):Unit = { insert(length(), elem) }

}