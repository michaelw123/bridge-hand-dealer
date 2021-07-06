package dealer

import predicate.{EqualTo, GreaterThan, LessThan}



case class PointsGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f=Hand.points)
case class PointsLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.points)
case class PointsEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f=Hand.points)
case class SpadesGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f= Hand.spadeLength)
case class SpadesLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.spadeLength)
case class SpadesEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f= Hand.spadeLength)