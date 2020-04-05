package com.atguigu.three

object Test_class {

  def main(args: Array[String]): Unit = {

      val test:Test[Person] =new Test[Student];
      println(test)
  }


}

class God {}

class Person extends God {}

class Student extends Person {}

class Test[Student]{}