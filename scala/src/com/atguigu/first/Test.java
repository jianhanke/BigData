package com.atguigu.first;

public class Test {

    public static void main(String[] args) {
        test(Person.class);

        test03(Person.class);
        test03(God.class);


    }

    public static void test(Class<Person> c){}
    public static void test02(Class<? extends  Person> c){}
    public static void test03(Class<? super Person> c){}
}

class God{

}
class Person extends God{

}
class Stud extends  Person{

}