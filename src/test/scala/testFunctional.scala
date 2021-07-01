
import core.{Deck, FunctionalShuffle, PointsEq, PointsGreaterThan}



object testFunctional extends App {
 val pred =PointsGreaterThan(20) and PointsEq(20)

  val (h, _) = FunctionalShuffle.shuffle1(Deck.cards, pred)
  h.println
}
