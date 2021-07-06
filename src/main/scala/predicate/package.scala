

package object predicate {
  trait Predicate[T]{
    def eval:T => Boolean
    def or(p2:Predicate[T]) = OrPredicate[T](this, p2)
    def and(p2:Predicate[T]) =  AndPredicate[T](this, p2)
  }
  case class Nope[T]() extends Predicate[T] {
    def eval:T => Boolean = (_) => true
  }

  case class OrPredicate[T](p1:Predicate[T], p2:Predicate[T]) extends Predicate[T] {
    def eval = (h:T) => p1.eval(h) || p2.eval(h)
  }
  case class AndPredicate[T](p1:Predicate[T], p2:Predicate[T]) extends Predicate[T] {
    def eval = (h:T) => p1.eval(h) && p2.eval(h)
  }
  class GreaterThan[T](mark:Int,  f: T => Int) extends Predicate[T] {
   def eval = (h:T) => f(h) > mark
  }
  class LessThan[T](mark:Int, f: T => Int) extends Predicate[T] {
    def eval = (h: T) => f(h) < mark
  }

  class EqualTo[T](mark:Int, f: T => Int) extends Predicate[T] {
    def eval = (h:T) => f(h) > mark
  }
}
