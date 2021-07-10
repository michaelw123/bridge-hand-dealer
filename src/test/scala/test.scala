
import dealer.{Board, PointsGreaterThan, Shuffle}
import dealer.OpenBid._
import predicate.Nope

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

  val b1:Board = Shuffle.shuffle(OneSpadeOpen,  Nope(), PointsGreaterThan(6), Nope())
  b1.north.println
  println
  b1.south.println
}
