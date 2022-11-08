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

object SeqStuff {
  def main(args:Array[String]):Unit = {
    val ls = new LinkedSeq[Char]()
    ls += 'A'
    ls += 'B'
    ls += 'C'
    ls += 'Q'
    /*
    for(i <- 0 until ls.length()) {
      println(ls.get(i))
    }
    var it = ls.iterator
    while(it.hasNext) {
      println(it.next)
    }
    it = ls.iterator
    println(it.length)
    it = ls.iterator
    for(x <- it) {
      println(x)
    }*/

    for(x <- ls) {
      println(x)
    }
    println(ls.mkString("!@!#"))
    println(ls.map(x => x.toString * 3))
    

  }
}


