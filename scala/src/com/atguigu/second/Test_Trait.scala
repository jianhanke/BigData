package com.atguigu.second

object Test_Trait {

  def main(args: Array[String]): Unit = {
      var stu=new Student
      stu.showSlog
  }
}
class Person{}
trait  Father {
    def showSlog: Unit ={
      println("I am a father")
    }
}
trait  Mother {
  def showSlog: Unit = {
    println("I am a mom")
  }
}
class Student extends  Mother with Father {
  override def showSlog: Unit = super.showSlog
}
