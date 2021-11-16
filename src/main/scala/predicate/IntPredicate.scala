package predicate

object IntPredicate {
  case class IntLessThan(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a < mark
  }
  case class IntGreaterThan(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a > mark
  }
  case class IntEqualTo(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a == mark
  }
}
