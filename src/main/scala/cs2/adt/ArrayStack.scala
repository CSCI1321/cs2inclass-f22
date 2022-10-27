package cs2.adt

class ArrayStack[A : Manifest] extends Stack[A] {
  var arr:Array[A] = Array.ofDim[A](10)
  var len = 0

  def push(elem:A):Unit = {
    /*
    val tmp:Array[A] = Array.ofDim[A](arr.length + 1)
    for(i <- 0 until arr.length) {
      tmp(i) = arr(i)
    }
    tmp(arr.length) = elem
    arr = tmp*/
    if(len == arr.length) { //out of space
      val tmp = Array.ofDim[A]( len * 2 )
      for(i <- 0 until len) {
        tmp(i) = arr(i)
      }
      arr = tmp
    }
    arr(len) = elem
    len += 1
  }
  def pop():A = {
    /*
    val tmp = Array.ofDim[A](arr.length - 1)
    for(i <- 0 until tmp.length) {
      tmp(i) = arr(i)
    }
    val result = arr(arr.length - 1)
    arr = tmp
    result*/
    val result = peek()
    len -= 1
    result
  }
  def peek():A = { arr(len - 1) }
  def isEmpty():Boolean = { len == 0 }
}