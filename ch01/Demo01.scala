/**
  * Created by lucky on 16-11-27.
  */

// 匿名函数
(x: Int) => x + 1

def timesTwo(i : Int): Int = {
  println("hello world")
  i * 2
}

/**
  partial application
  */
def adder(m: Int, n: Int) = m + n
// adder: (m: Int, n: Int)Int
val add2 = adder(2, _: Int)
// add2 (Int) => Int => <function>
// add2(3) = 5

/*
curry function
 */
def multiply(m: Int)(n: Int): Int = m * n
// multiply: (m: Int)(n: Int)Int
// 直接传入两个参数
multiply(2)(3)

// 填上第一个参数并部分应用第二个参数
val timesTwo = multiply(2) _
timesTwo(3)
// 6

/*
可变长度参数
 */
//
def captalizeAll(args: String*): Unit = {
  args.map{arg =>
    arg.capitalize
  }
}

/*
类
 */
class Calculator {
  val brand: String = "HP"
  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator
// calc: Calculator = Calculator@e75a11
calc.add(1, 2)
// res1: Int = 3
calc.brand
// res2: String = "HP"


/*
构造函数
构造函数不是特殊的方法，他们是除了类的方法定义之外的代码
 */
class Calculator2(brand: String) {
  /**
    * A constructor
    */
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HPT") {
    "black"
  } else {
    "white"
  }

  // an instance method
  def add(m: Int, n: Int): Int = m + n
}

// 使用构造函数来构造一个实例：
val calc2 = new Calculator2("HP")
calc2.color
// res0: String = black

/*
继承
 */
class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

/*
重载方法
 */
class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}


/*
抽象类
定义了一些方法但没有实现它们。取而代之是由扩展抽象类的子类定义这些方法。你不能创建抽象类的实例
 */
abstract class Shape {
  def getArea() : Int    // 子类应该定义此方法
}
class Circle(r: Int) extends Shape {
  def getArea(): Int = (r * r * 3)
}
val s = new Shape
/*
<console>:8: error: class Shape is abstract; cannot be instantiated
       val s = new Shape
               ^
 */
val c = new Circle(2)
// c: Circle = Circle@65c0035b


/*
特质(Traits)
是一些字段和行为的集合，可以扩展或混入（mixin）你的类中
*/
trait Car {
  val brand: String
}
trait Shiny {
  val shineRefraction: Int
}

class BMW extends Car {
  val brand = "BMW"
}
// 通过with关键字，一个类可以扩展多个特质：
class BMW2 extends Car with Shiny {
  val brand = "BMW"
  val shinyRefraction = 12
}



















