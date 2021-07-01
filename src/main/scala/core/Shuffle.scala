package core

import scala.annotation.tailrec

object Shuffle {
  def shuffle = {
    val shuffled:List[Card] = scala.util.Random.shuffle(Deck.cards)
    (Hand(shuffled.slice(0, 13)), Hand(shuffled.slice(13, 26)), Hand(shuffled.slice(26, 39)), Hand(shuffled.slice(39, 52)))
  }
  def shuffle(cards:List[Card]) = {
    val shuffled:List[Card] = scala.util.Random.shuffle(cards)
    (Hand(shuffled.slice(0, 13)), Hand(shuffled.slice(13, 26)), Hand(shuffled.slice(26, 39)), Hand(shuffled.slice(39, 52)))
  }
  @tailrec
  def shuffle1(cards:List[Card], p:Predicate):(Hand, List[Card]) = {
    val shuffled = scala.util.Random.shuffle(cards)
    val hand = Hand(shuffled.take(13))
    if (p.eval(hand) ) {
      (hand, shuffled.drop(13))
    } else shuffle1(cards, p)
  }
  def shuffle2(p1:Predicate, p3:Predicate) = {
    val (h1, _, h3, _) = shuffle(p1, EmptyPredicate(), p3, EmptyPredicate())
    (h1, h3)
  }
  def shuffle(p1:Predicate, p2:Predicate, p3:Predicate, p4:Predicate) = {
    val (h1,c1) = shuffle1(Deck.cards, p1)
    val (h2, c2) = shuffle1(c1, p2)
    val (h3, c3) = shuffle1(c2, p3)
    (h1, h2, h3, Hand(c3))
  }
}
