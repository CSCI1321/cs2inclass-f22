package cs2.algorithms

import scala.io.Source

object FileStuff {

  def main(args:Array[String]):Unit = {

    val path = getClass().getResource("/tempest.txt")
    val tempest = Source.fromURL(path).getLines()

    //var words = scala.collection.mutable.Set[String]()
    var wordCounts = scala.collection.mutable.Map[String, Int]()
    for(line <- tempest) {
      val strs = line.split("\\s+")
      for(s <- strs) {
        val word = s.filter(_.isLetter).toUpperCase
        if(wordCounts.contains(word)) {
          wordCounts(word) += 1
        } else {
          wordCounts(word) = 1
          //wordCounts += ((word, 1))
          //wordCounts += word -> 1
        }
      }

    }
    wordCounts -= ""
    println(wordCounts.size)
    println(wordCounts.toArray.mkString("\n"))
    println(wordCounts.toArray.sorted.mkString("\n"))
    println(wordCounts.values.toArray.sorted.mkString("\n"))

    val tupArray = wordCounts.toArray
    Sorting.bubbleSort(tupArray, (a:(String,Int),b:(String,Int)) => a._2 > b._2)
    println(tupArray.mkString("\n"))


    //println(words)
    //println(words.size)
    //println(words.contains("thee"))
    


  }


}