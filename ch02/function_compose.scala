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
}
