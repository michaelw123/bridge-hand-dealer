package core

object FunctionalShuffle {

  def shuffle1(cards:List[Card], p:FunctionalPredicate):(Hand, List[Card]) = {
    val shuffled = scala.util.Random.shuffle(cards)
    val hand = Hand(shuffled.take(13))
    if (p.eval(hand) ) {
      (hand, shuffled.drop(13))
    } else shuffle1(cards, p)
  }
}
