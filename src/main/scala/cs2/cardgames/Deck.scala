package cs2.cardgames

class Deck() {
  private var cards:List[Card] = List() //Nil

  def shuffle():Unit = {
    cards = scala.util.Random.shuffle(cards)
  }
  def deal():Card = {
    val c = cards.head
    cards = cards.tail
    c
  }
  def addTop(c:Card):Unit = {
    cards ::= c
  }
  def addBottom(c:Card):Unit = {
    //cards = (c :: cards.reverse).reverse
    cards = cards ::: List(c)
  }
  
}

object Deck {
  def empty():Deck = new Deck()
  def apply():Deck = {
    val d = new Deck()
    for(r <- 1 to 13) {
      for(s <- Card.SUITS) {
        d.cards = Card(r,s) :: d.cards
        //d.cards ::= Card(r,s)
      }
    }
    d
  }

  def main(args:Array[String]):Unit = {
    val anEmptyDeck = Deck.empty()
    val theDeck = Deck()
    theDeck.shuffle()
    for(c <- theDeck.cards) {
      println(c)
    }
  }
}