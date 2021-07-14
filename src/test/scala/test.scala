
import dealer.{Board, PointsGreaterThan, Shuffle}
import dealer.OpenBid._
import predicate.{IntLessThan, Nope, IntGreaterThan, IntEqualTo}

object test extends App {


//  north.foreach(print)
//  println
////  east.foreach(print)
////  println
////  south.foreach(print)
////  println
////  west.foreach(print)
////  println
//
//  val northhand = Hand(north)
//
//  val x = northhand.spades.map(_.suitname)
//  println(northhand.points)
//  println(northhand.spadeLength)
//  println(northhand.heartsLength)
//  println(northhand.diamondLength)
//  println(northhand.clubLength)
//  println(northhand.show)

//  val (hand, _) = Shuffle.shuffle1(Deck.cards, OneMajorOpen)
//
//  println(hand.show)

//  val b:Board = Shuffle.shuffle(OneSpadeOpen,  Nope(), PointsGreaterThan(6), Nope())
//  b.north.println
//  println
//  b.south.println

//  val b1:Board = Shuffle.shuffle(OneSpadeOpen,  Nope(), PointsGreaterThan(6), Nope())
//  b1.north.println
//  println
//  b1.south.println

  val l = List(1,2, 3,4,5,6,7,8,9,10)
  val ll =   l.filter((IntLessThan(5) and IntGreaterThan(2)) or IntEqualTo(10))

  ll.foreach(println)
}
