class runnable extends App {
  val stack = Cons(1, Cons(2, Empty))
  println(stack.head)
}


/*
trait Stack[T] {
  def isEmpty: Boolean
  def cons(t: T): Stack[T]
  def head: T
  def tail: Stack[T]
}
 */
/**
  make Stack trait more general
  */

trait Stack[+T] {
  def isEmpty: Boolean
  def cons[U >: T](t: U): Stack[U]
  def head: T
  def tail: Stack[T]
}

/**  A Stack could be empty or it could have a head and tail */
/*
sealed abstract class CList[+T] extends Stack[T] {
  def cons[U >: T](t: U): CList[U] = new Cons(t, this)
}

case object Empty extends CList[Nothing] {
  def isEmpty:Boolean = true
  def head: Nothing = throw new NoSuchElementException()
  def tail: Nothing = throw new NoSuchElementException()
}

case class Cons[+T](hd: T, tl: CList[T]) extends CList[T] {
  def isEmpty: Boolean = false
  def head: T = hd
  def tail: CList[T] = tl
}
 */

// ---------------------------------------------------------------
/*
 other operation
 */
// update: inserts an element at a given index
// ++ : catenates two Stack together
sealed abstract class CList[+T] extends Stack[T] {
  def ++[U >: T](ys: CList[U]): CList[U]
  def update[U >: T](t: U, i: Int): CList[U]
  def toList: List[T]
}

case object Empty extends CList[Nothing] {
  def ++[U](ys: CList[U]): CList[U] = ys
  def update[U](t: U, i: Int) = throw new IndexOutOfBoundsException()
  def toList = Nil
}

case class Cons[+T](hd: T, tl: CList[T]) extends CList[T] {
  def ++[U >: T](ys: CList[U]): CList[U] = Cons(head, tail ++ ys)
  def update[U >: T](t: U, i: Int): CList[U] = if (i == 0) Cons(t, this) else
    Cons(head, tail.update(t, i - 1))
  def toList = head :: tail.toList
}

