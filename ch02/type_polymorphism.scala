class runnable extends App {

  /**
    covariant协变
    C[T’]是 C[T] 的子类, [+T]
    contravariant逆变
    C[T] 是 C[T’]的子类, [-T]
    invariant不变
    C[T] 和 C[T’]无关, [T]
    */
  class Covariant[+A]
  // defined class Covariant
  val cv: Covariant[AnyRef] = new Covariant[String]
  // cv: Covariant[AnyRef] = Covariant@4035acf6
  val cv: Covariant[String] = new Covariant[AnyRef]
  /**
    <console>:6: error: type mismatch;
    found   : Covariant[AnyRef]
    required: Covariant[String]
    val cv: Covariant[String] = new Covariant[AnyRef]
                                ^
    */
}
