import core.OpenBid._
import core.{Board, Deck, EmptyPredicate, Hand, PointsGreaterAndEqThanPredicate, PointsLessThanAndEqualPredicate, Shuffle}

object test extends App {
  //Deck.cards.foreach(println)

//  println(Deck.cards.map(_.points).sum)
//
//  val (north, east, south, west) = Shuffle.shuffle(Deck.cards)
//
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

  val b:Board = Shuffle.shuffle(OneMajorOpen,  EmptyPredicate(), PointsGreaterAndEqThanPredicate(6), EmptyPredicate())
  b.north.println
  println
  b.south.println
}
