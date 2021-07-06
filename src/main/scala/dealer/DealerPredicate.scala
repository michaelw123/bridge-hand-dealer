package dealer

import predicate.{EqualTo, GreaterThan, LessThan}



case class PointsGreaterThan(mark:Int,  f:Hand=>Int = Hand.points) extends GreaterThan[Hand](mark:Int, f)
case class PointsLessThan(mark:Int,  f:Hand=>Int = Hand.points) extends LessThan[Hand](mark:Int, f)
case class PointsEqualTo(mark:Int, f:Hand=>Int = Hand.points) extends EqualTo[Hand](mark:Int, f)
case class SpadesGreaterThan(mark:Int, f:Hand=>Int = Hand.spadeLength) extends GreaterThan[Hand](mark:Int, f)
case class SpadesLessThan(mark:Int, f:Hand=>Int = Hand.spadeLength) extends LessThan[Hand](mark:Int, f)
case class SpadesEqualTo(mark:Int, f:Hand=>Int = Hand.spadeLength) extends EqualTo[Hand](mark:Int, f)