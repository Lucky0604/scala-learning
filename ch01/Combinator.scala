
object runnable extends App {
  val numbers = List(1,2,3,4,5)

  def timesTwo(i: Int): Int = i * 2

  println(test.ourMap(numbers, timesTwo(_)))
  // 2,4,6,8,10

  // Map可以被看作是一个二元组的列表，所以你写的函数要处理一个键和值的二元组。
  val extensions = Map("steven" -> 100, "bob" -> 101, "joe" -> 201)
  // 筛选出电话分机号码低于200的条目。
  println(extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200))
  // 可以使用模式匹配更优雅地提取键和值
  println(extensions.filter({case (name, extension) => extension < 200}))
}

object test {

  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) {(x: Int, xs: List[Int]) =>
      fn(x) :: xs
    }
  }


}



