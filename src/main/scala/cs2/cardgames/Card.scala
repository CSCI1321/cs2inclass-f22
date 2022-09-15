package cs2.cardgames

class Card(val rank:Int, val suit:Char) {

  def isRed():Boolean = {
    suit == Card.HEART || suit == Card.DIAMOND
  }
  def isBlack():Boolean = !isRed()

  def < (other:Card):Boolean = { this.rank < other.rank }
  def > (other:Card):Boolean = { this.rank > other.rank }
  def == (other:Card):Boolean = { this.rank == other.rank }

  override def toString():String = {
    val rankStr = rank match {
      case 1 => "Ace"
      case 11 => "Jack"
      case 12 => "Queen"
      case 13 => "King"
      case x => x.toString
    }
    rankStr + " of " + suit
  }

}

object Card {
  val HEART = 'H'
  val DIAMOND = 'D'
  val SPADE = 'S'
  val CLUB = 'C'
  val SUITS = Array(HEART, DIAMOND, SPADE, CLUB)

  def apply(r:Int, s:Char):Card = new Card(r,s)
  def apply():Card = new Card(1,SPADE)

  def main(args:Array[String]):Unit = {
    println(HEART)
    val c = Card()
    println(c)
    val d = Card(12,HEART)
    println(d)
    println(d.isBlack())
    println(c > d)
  }

}

