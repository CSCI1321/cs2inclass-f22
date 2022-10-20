package cs2.algorithms

object Sorting {

  def bubbleSort[A] (arr:Array[A], gt:(A,A) => Boolean):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1) {
        if(gt(arr(i), arr(i+1))) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  def bubbleSort[A <% Ordered[A]] (arr:Array[A]):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1) {
        if(arr(i) > arr(i+1)) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  class Student(var name:String, var gpa:Double) extends Ordered[Student] {
    def compare(other:Student):Int = { name.compareTo(other.name) }
  }

  def main(args:Array[String]):Unit = {
    val a = Array.fill(10)(math.random())
    val b = Array("Hello","Goodbye","alice","Bob","Cindy","Foo","Bar","Baz")
    bubbleSort(a)
    bubbleSort(b, (x:String,y:String) => x > y)
    val c = Array(new Student("Alice",4.0), new Student("Bob",3.5), new Student("Aaron",3.25))
    println(a.mkString(","))
    println(b.mkString(","))
    bubbleSort(c)
    c.foreach(x => println(x.name))
  }



}