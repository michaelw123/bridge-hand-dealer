package object predicate {
  trait Predicate[T] extends Function[T, Boolean]{
    def or(p2:Predicate[T]) = OrPredicate[T](this, p2)
    def and(p2:Predicate[T]) =  AndPredicate[T](this, p2)
    def unary_! = NotPredicate[T](this)
  }
  case class Nope[T]() extends Predicate[T] {
    def apply(a:T) = true
  }
  case class OrPredicate[T](p1:Predicate[T], p2:Predicate[T]) extends Predicate[T] {
    def apply(a:T) = p1(a) || p2(a)
  }
  case class AndPredicate[T](p1:Predicate[T], p2:Predicate[T]) extends Predicate[T] {
    def apply(a:T) = p1(a) && p2(a)
  }
  case class NotPredicate[T](p:Predicate[T])  extends Predicate[T] {
    def apply(a:T) = !p(a)
  }
  class GreaterThan[T](mark:Int,  f: T => Int) extends Predicate[T] {
   def apply(a:T) = f(a) > mark
  }
  class LessThan[T](mark:Int, f: T => Int) extends Predicate[T] {
    def apply(a:T) = f(a) < mark
  }

  class EqualTo[T](mark:Int, f: T => Int) extends Predicate[T] {
    def apply(a:T) = f(a) == mark
  }

  implicit class IntLessThan(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a < mark
  }
  implicit class IntGreaterThan(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a > mark
  }
  implicit class IntEqualTo(mark:Int) extends Predicate[Int] {
    def apply(a:Int) = a == mark
  }
}
