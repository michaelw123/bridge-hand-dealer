package core

trait Predicate {
  def eval(h:Hand):Boolean
  def or(p2:Predicate) = OrPredicate(this, p2)
  def and(p2:Predicate) =  AndPredicate(this, p2)
}
case class EmptyPredicate() extends Predicate {
  def eval (h:Hand) = true
}
case class AndPredicate (p1:Predicate, p2:Predicate) extends Predicate {
  def eval (h:Hand) = p1.eval(h) && p2.eval(h)
}
case class OrPredicate (p1:Predicate, p2:Predicate) extends Predicate {
  def eval (h:Hand) = p1.eval(h) || p2.eval(h)
}
case class PointsGreaterAndEqThanPredicate(mark:Int) extends Predicate {
   def eval(h:Hand):Boolean = h.points >= mark
}
case class PointsLessThanAndEqualPredicate(mark:Int) extends Predicate {
   def eval(h:Hand):Boolean = h.points <= mark
}
case class SuitsLessThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand:Hand):Boolean =
    hand.spadeLength <= mark && hand.heartLength <= mark && hand.diamondLength<=mark && hand.clubLength <= mark
}
case class SuitsGreaterThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand:Hand):Boolean = {
    hand.spadeLength >= mark && hand.heartLength >= mark && hand.diamondLength >=mark && hand.clubLength >= mark
  }
}
case class SpadeGreaterThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.spadeLength >= mark
}
case class HeartGreaterThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.heartLength >= mark
}
case class DiamondGreaterThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.diamondLength >= mark
}
case class ClubGreaterThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.clubLength >= mark
}
case class SpadeLessThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.spadeLength >= mark
}
case class HeartLessThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.heartLength >= mark
}
case class DiamondLessThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.diamondLength >= mark
}
case class ClubLessThanAndEqualPredicate(mark:Int) extends Predicate {
  def eval(hand: Hand): Boolean = hand.clubLength >= mark
}

