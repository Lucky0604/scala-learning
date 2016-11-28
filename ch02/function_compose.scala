object runnable extends App {

  // create two functions
  def f(s: String) = "f(" + s + ")"
  def g(s: String) = "g(" + s + ")"

  // compose 组合其他函数形成一个新的函数 f(g(x))
  val fComposeG = f _ compose g _
  println(fComposeG("yay"))
  // f(g(yay))

  // andThen is similar as compose, but call the first one
  val fAndThenG = f _ andThen g _
  println(fAndThenG("yay"))
  // g(f(yay))

  /**
    * 偏函数
    对给定的输入参数类型，函数可接受该类型的任何值。换句话说，一个(Int) => String 的函数可以接收任意Int值，并返回一个字符串。
    对给定的输入参数类型，偏函数只能接受该类型的某些特定的值。一个定义为(Int) => String 的偏函数可能不能接受所有Int值为输入。
    */
  val one: PatialFunction[Int, String] = {case 1 => "one"}
  // one: PartialFunction[Int,String] = <function1>
  println(one.isDefinedAt(1))
  // res0: Boolean = true
  println(one.isDefinedAt(2))
  // res1: Boolean = false

  // 调用偏函数
  println(one(1))
  // res2: String = one

  /*
   * 使用orElse组成新的函数，得到的PartialFunction反映了是否对给定参数进行了定义
   */
  val two: PatialFunction[Int, String] = {case 2 => "two"}
  val three: PatialFunction[Int, String] = {case 3 => "three"}
  val wildcard: PatialFunction[Int, String] = {case _ => "something else"}
  val partial = one orElse two orElse three orElse wildcard
  println(partial(5))
  // res24: String = something else
  println(partial(3))
  // res25: String = three
  println(partial(2))
  // res26: String = two
  println(partial(1))
  // res27: String = one
  println(partial(0))
  // res28: String = something else
}
