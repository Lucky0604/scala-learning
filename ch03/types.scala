object runnable extends App {
  /**
    Parametric polymorphism
    */
  println(2 :: 1 :: "bar" :: "foo" :: Nil)

  /*
   在Scala中所有类型推断是 局部的
   */
  def id[T](x: T) = x
  val x = id(322)
  println(x)
  // x: Int = 322
  val x = id("hey")
  println(x)
  // x: java.lang.String = hey
  val x = id(Array(1,2,3,4))
  println(x)
  // x: Array[Int] = Array(1,2,3,4)


}
