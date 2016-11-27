/**
  * Created by lucky on 16-11-27.
  */

/**
  * 单例对象
  * 单例对象用于持有一个类的唯一实例。通常用于工厂模式。
  */
object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }
}
println(Timer.currentCount())















