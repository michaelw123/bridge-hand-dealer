import core.HeartCard

package object core {
  sealed trait Suit {
    def suitname:String
  }
  trait SpadeSuit extends Suit {
    def suitname = "S"
  }
  trait HeartSuit extends Suit{
    def suitname = "H"
  }
  trait DiamondSuit extends Suit{
    def suitname = "D"
  }
  trait ClubSuit extends Suit{
    def suitname = "C"
  }

  sealed trait Rank {
    def rankname:String
    def points:Int = 0
    def ranking:Int = 0
  }
  trait Ace extends Rank {
    def rankname = "A"
    override def points:Int = 4
    override def ranking:Int = 14
  }
  trait King extends Rank {
    def rankname = "K"
    override def points:Int = 3
    override def ranking:Int = 13
  }
  trait Queen extends Rank {
    def rankname = "Q"
    override def points:Int = 2
    override def ranking:Int = 12
  }
  trait Jack extends Rank {
    def rankname = "J"
    override def points:Int = 1
    override def ranking:Int = 11
  }
  trait Ten extends Rank {
    def rankname = "T"
    override def ranking:Int = 10
  }
  trait Nine extends Rank {
    def rankname = "9"
    override def ranking:Int = 9
  }
  trait Eight extends Rank {
    def rankname = "8"
    override def ranking:Int = 8
  }
  trait Seven extends Rank {
    def rankname = "7"
    override def ranking:Int = 7
  }
  trait Six extends Rank {
    def rankname = "6"
    override def ranking:Int = 6
  }
  trait Five extends Rank {
    def rankname = "5"
    override def ranking:Int = 5
  }
  trait Four extends Rank {
    def rankname = "4"
    override def ranking:Int = 4
  }
  trait Three extends Rank {
    def rankname = "3"
    override def ranking:Int = 3
  }
  trait Two extends Rank {
    def rankname = "2"
    override def ranking:Int = 2
  }

  trait Card extends Suit with Rank
  sealed trait SpadeCard extends Card with SpadeSuit
  case object SA extends SpadeCard with Ace
  case object SK extends SpadeCard with King
  case object SQ extends SpadeCard with Queen
  case object SJ extends SpadeCard with Jack
  case object ST extends SpadeCard with Ten
  case object S9 extends SpadeCard with Nine
  case object S8 extends SpadeCard with Eight
  case object S7 extends SpadeCard with Seven
  case object S6 extends SpadeCard with Six
  case object S5 extends SpadeCard with Five
  case object S4 extends SpadeCard with Four
  case object S3 extends SpadeCard with Three
  case object S2 extends SpadeCard with Two

  sealed trait HeartCard extends Card with HeartSuit
  case object HA extends HeartCard with Ace
  case object HK extends HeartCard with King
  case object HQ extends HeartCard with Queen
  case object HJ extends HeartCard with Jack
  case object HT extends HeartCard with Ten
  case object H9 extends HeartCard with Nine
  case object H8 extends HeartCard with Eight
  case object H7 extends HeartCard with Seven
  case object H6 extends HeartCard with Six
  case object H5 extends HeartCard with Five
  case object H4 extends HeartCard with Four
  case object H3 extends HeartCard with Three
  case object H2 extends HeartCard with Two

  sealed trait DiamondCard extends Card with DiamondSuit
  case object DA extends DiamondCard with Ace
  case object DK extends DiamondCard with King
  case object DQ extends DiamondCard with Queen
  case object DJ extends DiamondCard with Jack
  case object DT extends DiamondCard with Ten
  case object D9 extends DiamondCard with Nine
  case object D8 extends DiamondCard with Eight
  case object D7 extends DiamondCard with Seven
  case object D6 extends DiamondCard with Six
  case object D5 extends DiamondCard with Five
  case object D4 extends DiamondCard with Four
  case object D3 extends DiamondCard with Three
  case object D2 extends DiamondCard with Two

  sealed trait ClubCard extends Card with ClubSuit
  case object CA extends ClubCard with Ace
  case object CK extends ClubCard with King
  case object CQ extends ClubCard with Queen
  case object CJ extends ClubCard with Jack
  case object CT extends ClubCard with Ten
  case object C9 extends ClubCard with Nine
  case object C8 extends ClubCard with Eight
  case object C7 extends ClubCard with Seven
  case object C6 extends ClubCard with Six
  case object C5 extends ClubCard with Five
  case object C4 extends ClubCard with Four
  case object C3 extends ClubCard with Three
  case object C2 extends ClubCard with Two


  object Deck {
    val cards:List[Card] = List(
      SA, SK, SQ, SJ, ST, S9, S8, S7, S6, S5, S4, S3, S2,
      HA, HK, HQ, HJ, HT, H9, H8, H7, H6, H5, H4, H3, H2,
      DA, DK, DQ, DJ, DT, D9, D8, D7, D6, D5, D4, D3, D2,
      CA, CK, CQ, CJ, CT, C9, C8, C7, C6, C5, C4, C3, C2
    )
  }

  case class Hand(spades:List[Card] = List.empty[SpadeCard],
                  hearts:List[Card] = List.empty[HeartCard],
                  diamonds:List[Card] =  List.empty[DiamondCard],
                  clubs:List[Card] = List.empty[ClubCard]) {
    def points = spades.map(_.points).sum + hearts.map(_.points).sum + diamonds.map(_.points).sum + clubs.map(_.points).sum
    def spadeLength = spades.size
    def heartLength = hearts.size
    def diamondLength =  diamonds.size
    def clubLength = clubs.size
    def println = Console.println(show)
    def show = "S " + spades.foldRight("")((a, b) => a.rankname+b) + sys.props("line.separator") +
          "H "+ hearts.foldRight("")((a, b) => a.rankname+b) +sys.props("line.separator") +
          "D "+ diamonds.foldRight("")((a, b) => a.rankname+b) +sys.props("line.separator") +
          "C "+ clubs.foldRight("")((a, b) => a.rankname+b)
  }

  case class Board(north:Hand, east:Hand, south:Hand, west:Hand) {
    def show = north.show + sys.props("line.separator") +sys.props("line.separator")+
      east.show + sys.props("line.separator") +sys.props("line.separator")+
      south.show + sys.props("line.separator") +sys.props("line.separator")+
      west.show + sys.props("line.separator")
    def println =  Console.println(show)
  }
  object Board {
    implicit def apply(x:(Hand, Hand, Hand, Hand)):Board =  Board(x._1, x._2, x._3, x._4)
  }

  object Hand {
    def apply(cards:List[Card]):Hand = Hand (
      spades = cards.filter(_.suitname=="S").sortBy(_.ranking).reverse,
      hearts = cards.filter(_.suitname=="H").sortBy(_.ranking).reverse,
      diamonds = cards.filter(_.suitname=="D").sortBy(_.ranking).reverse,
      clubs = cards.filter(_.suitname=="C").sortBy(_.ranking).reverse
    )
    def apply:Hand = Hand(
      spades = List.empty[Card],
      hearts = List.empty[Card],
      diamonds = List.empty[Card],
      clubs = List.empty[Card]
    )
  }
}
