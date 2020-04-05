package com.atguigu.three

object Test_class {

  def main(args: Array[String]): Unit = {
    test2(new Student)
    test2(new God)
    test2(new Person)
  }
  def test[T<:Person](t:T): Unit ={

  }
  def test2[T>:Person](t:T): Unit ={

  }

}

class God {}

class Person extends God {}

class Student extends Person {}

