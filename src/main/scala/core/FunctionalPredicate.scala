package core

import core.FunctionalPredicate.{pointsEq, pointsGreaterThan}

trait FunctionalPredicate{
  def eval:Hand => Boolean
  def or(p2:FunctionalPredicate) = OrFunctionalPredicate(this, p2)
  def and(p2:FunctionalPredicate) =  AndFunctionalPredicate(this, p2)
}
object FunctionalPredicate {
  def pointsGreaterThan(mark:Int)(h:Hand) = h.points > mark
  def pointsLessThan(mark:Int)(h:Hand) = h.points > mark
  def pointsEq(mark:Int)(h:Hand) = h.points > mark
  def spadeLengthGreaterThan(mark:Int)(h:Hand) = h.spadeLength > mark
  def spadeLengthLessThan(mark:Int)(h:Hand) = h.spadeLength < mark
  def spadeLengthEq(mark:Int)(h:Hand) = h.spadeLength == mark
  def heartLengthGreaterThan(mark:Int)(h:Hand) = h.heartLength > mark
  def heartLengthLessThan(mark:Int)(h:Hand) = h.heartLength < mark
  def heartLengthEq(mark:Int)(h:Hand) = h.heartLength == mark
  def diamondLengthGreaterThan(mark:Int)(h:Hand) = h.diamondLength > mark
  def diamondLengthLessThan(mark:Int)(h:Hand) = h.diamondLength < mark
  def diamondLengthEq(mark:Int)(h:Hand) = h.diamondLength == mark
  def clubLengthGreaterThan(mark:Int)(h:Hand) = h.clubLength > mark
  def clubLengthLessThan(mark:Int)(h:Hand) = h.clubLength < mark
  def clubLengthEq(mark:Int)(h:Hand) = h.clubLength == mark
}
object Nope extends FunctionalPredicate {
  def eval = (_) => true
}
case class OrFunctionalPredicate(p1:FunctionalPredicate, p2:FunctionalPredicate) extends FunctionalPredicate {
  def eval = (h:Hand) => p1.eval(h) || p2.eval(h)
}

case class AndFunctionalPredicate(p1:FunctionalPredicate, p2:FunctionalPredicate) extends FunctionalPredicate {
  def eval = (h:Hand) => p1.eval(h) && p2.eval(h)
}

case class PointsGreaterThan(mark:Int) extends FunctionalPredicate {
  def eval = pointsGreaterThan(mark)
}
case class PointsEq(mark:Int) extends FunctionalPredicate {
  def eval = pointsEq(mark)
}


