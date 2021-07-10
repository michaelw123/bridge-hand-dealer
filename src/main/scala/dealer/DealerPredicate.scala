package dealer

import predicate.{EqualTo, GreaterThan, LessThan}



case class PointsGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f=Hand.points)
case class PointsLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.points)
case class PointsEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f=Hand.points)

case class SpadesGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f= Hand.spadeLength)
case class SpadesLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.spadeLength)
case class SpadesEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f= Hand.spadeLength)

case class HeartsGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f= Hand.heartLength)
case class HeartsLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.heartLength)
case class HeartsEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f= Hand.heartLength)

case class DiamondsGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f= Hand.diamondLength)
case class DiamondsLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.diamondLength)
case class DiamondsEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f= Hand.diamondLength)

case class ClubsGreaterThan(mark:Int) extends GreaterThan[Hand](mark:Int, f= Hand.clubLength)
case class ClubsLessThan(mark:Int) extends LessThan[Hand](mark:Int, f=Hand.clubLength)
case class ClubsEqualTo(mark:Int) extends EqualTo[Hand](mark:Int, f= Hand.clubLength)